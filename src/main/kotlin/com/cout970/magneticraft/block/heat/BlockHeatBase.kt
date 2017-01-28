package com.cout970.magneticraft.block.heat

import com.cout970.magneticraft.block.BlockBase
import net.minecraft.block.ITileEntityProvider
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World

/**
 * Created by cout970 on 04/07/2016.
 */
abstract class BlockHeatBase(material: Material, name: String) : BlockBase(material,
        name), ITileEntityProvider, IHeatBlock {

//  override fun onBlockPlacedBy(worldIn: World?, pos: BlockPos, state: IBlockState?, placer: EntityLivingBase, stack: ItemStack?) {
//      super.onBlockPlacedBy(worldIn, pos, state, placer, stack)
//      val tile = worldIn?.getTile<TileHeatSink>(pos) ?: return
//      tile.updateHeatConnections()
//  }

    override fun getLightValue(state: IBlockState?, world: IBlockAccess?, pos: BlockPos?): Int {
        return super.getHeatLightValue(state, world, pos)
    }

    override fun tickRate(worldIn: World?): Int {
        return 1
    }

    override fun onNeighborChange(world: IBlockAccess?, pos: BlockPos?, neighbor: BlockPos?) {
        super.heatNeighborCheck(world, pos, neighbor)
        super.onNeighborChange(world, pos, neighbor)
    }
}