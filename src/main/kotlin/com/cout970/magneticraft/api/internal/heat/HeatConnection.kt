package com.cout970.magneticraft.api.internal.heat

import com.cout970.magneticraft.api.heat.IHeatConnection
import com.cout970.magneticraft.api.heat.IHeatNode

/**
 * Created by cout970 on 11/06/2016.
 */
open class HeatConnection(
        private val firstNode: IHeatNode,
        private val secondNode: IHeatNode
) : IHeatConnection {

    override fun getFirstNode() = firstNode
    override fun getSecondNode() = secondNode

    override fun iterate() {
        //Use the lowest conductivity.
        val minConductivity = Math.min(firstNode.conductivity, secondNode.conductivity)
        if (minConductivity <= 0) return
        //Heat moving in the other direction is handled in the other entity
        if (firstNode.temperature > secondNode.temperature) {
            var heatToTransfer = (Math.floor(Math.abs(firstNode.temperature - secondNode.temperature) * minConductivity)).toLong()
            heatToTransfer -= secondNode.pushHeat(heatToTransfer, false) //If the block accepts all the heat, we subtract all of it
            firstNode.pullHeat(heatToTransfer, false)                    //If there's any leftover, we effectively add it back
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other is IHeatConnection) {
            return firstNode == other.firstNode && secondNode == other.secondNode
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return (super.hashCode() * 31 + firstNode.hashCode()) * 31 + secondNode.hashCode()
    }

    override fun toString(): String {
        return "HeatConnection(firstNode=$firstNode, secondNode=$secondNode)"
    }
}