package babbies.mod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import babbies.mod.Leopold;
import babbies.mod.reference.Reference;
import net.minecraft.block.BlockFire;

public class BlockPortalDoop extends BlockPortal {

	public BlockPortalDoop(String unlocalizedName, Material material, float localHardness, float localResistance) {
		super();
		this.setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, unlocalizedName);
		this.setUnlocalizedName(Reference.MODID + "_" + unlocalizedName);
		setHarvestLevel("pickaxe",3);
		setStepSound(soundTypeStone);
		setHardness(localHardness);
		setResistance(localResistance);
	}

	@Override
	public int getLightValue(IBlockAccess world, BlockPos pos) {
		return 14;
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (entityIn.ridingEntity == null && entityIn.riddenByEntity == null) {
			int id = Leopold.doopDimID;
			if (entityIn.dimension == id) {
				id = 0;
			}
			if (entityIn instanceof EntityPlayerMP) {

				EntityPlayerMP player = (EntityPlayerMP) entityIn;
				MinecraftServer mcServer = player.mcServer;

				if (player.timeUntilPortal > 0) {
					player.timeUntilPortal = 10;
				}
				else if (player.dimension != Leopold.doopDimID) {
					player.timeUntilPortal = 10;
					player.mcServer.getConfigurationManager().transferPlayerToDimension(player, Leopold.doopDimID, new TeleporterDoop(mcServer.worldServerForDimension(Leopold.doopDimID)));
				}
				else {
					player.timeUntilPortal = 10;
					player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterDoop(mcServer.worldServerForDimension(0)));
				}
			}
		}
	}

	@Override
	public boolean func_176548_d(World worldIn, BlockPos p_176548_2_) {
		BlockPortalDoop.Size size = new BlockPortalDoop.Size(worldIn, p_176548_2_, EnumFacing.Axis.X);

		if (size.func_150860_b() && size.field_150864_e == 0) {
			size.func_150859_c();
			return true;
		}
		else {
			BlockPortalDoop.Size size1 = new BlockPortalDoop.Size(worldIn, p_176548_2_, EnumFacing.Axis.Z);

			if (size1.func_150860_b() && size1.field_150864_e == 0) {
				size1.func_150859_c();
				return true;
			}
			else {
				return false;
			}
		}
	}

	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		int par2 = pos.getX();
		int par3 = pos.getY();
		int par4 = pos.getZ();

		if (rand.nextInt(100) == 0) {
			worldIn.playSound(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, "portal.portal", 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
		}

		for (int i = 0; i < 4; ++i) {
			double d0 = pos.getX() + rand.nextFloat();
			double d1 = pos.getY() + rand.nextFloat();
			double d2 = pos.getZ() + rand.nextFloat();
			double d3 = (rand.nextFloat() - 0.5D) * 0.5D;
			double d4 = (rand.nextFloat() - 0.5D) * 0.5D;
			double d5 = (rand.nextFloat() - 0.5D) * 0.5D;
			int j = rand.nextInt(2) * 2 - 1;

			if (worldIn.getBlockState(pos.west()).getBlock() != this && worldIn.getBlockState(pos.east()).getBlock() != this) {
				d0 = pos.getX() + 0.5D + 0.25D * j;
				d3 = rand.nextFloat() * 2.0F * j;
			}
			else {
				d2 = pos.getZ() + 0.5D + 0.25D * j;
				d5 = rand.nextFloat() * 2.0F * j;
			}
		}
	}

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
		EnumFacing.Axis axis = (EnumFacing.Axis) state.getValue(AXIS);
		BlockPortalDoop.Size size;

		if (axis == EnumFacing.Axis.X) {
			size = new BlockPortalDoop.Size(worldIn, pos, EnumFacing.Axis.X);

			if (!size.func_150860_b() || size.field_150864_e < size.field_150868_h * size.field_150862_g) {
				worldIn.setBlockState(pos, Blocks.air.getDefaultState());
			}
		}
		else if (axis == EnumFacing.Axis.Z) {
			size = new BlockPortalDoop.Size(worldIn, pos, EnumFacing.Axis.Z);

			if (!size.func_150860_b() || size.field_150864_e < size.field_150868_h * size.field_150862_g) {
				worldIn.setBlockState(pos, Blocks.air.getDefaultState());
			}
		}
	}

	public static class Size {
		private final World world;
		private final EnumFacing.Axis axis;
		private final EnumFacing field_150866_c;
		private final EnumFacing field_150863_d;
		private int field_150864_e = 0;
		private BlockPos field_150861_f;
		private int field_150862_g;
		private int field_150868_h;
		private static final String __OBFID = "CL_00000285";

		public Size(World worldIn, BlockPos p_i45694_2_, EnumFacing.Axis p_i45694_3_) {
			this.world = worldIn;
			this.axis = p_i45694_3_;

			if (p_i45694_3_ == EnumFacing.Axis.X) {
				this.field_150863_d = EnumFacing.EAST;
				this.field_150866_c = EnumFacing.WEST;
			}
			else {
				this.field_150863_d = EnumFacing.NORTH;
				this.field_150866_c = EnumFacing.SOUTH;
			}

			for (BlockPos blockpos1 = p_i45694_2_; p_i45694_2_.getY() > blockpos1.getY() - 21 && p_i45694_2_.getY() > 0 && this.func_150857_a(worldIn.getBlockState(p_i45694_2_.down()).getBlock()); p_i45694_2_ = p_i45694_2_.down()) {
				;
			}

			int i = this.func_180120_a(p_i45694_2_, this.field_150863_d) - 1;

			if (i >= 0) {
				this.field_150861_f = p_i45694_2_.offset(this.field_150863_d, i);
				this.field_150868_h = this.func_180120_a(this.field_150861_f, this.field_150866_c);

				if (this.field_150868_h < 2 || this.field_150868_h > 21) {
					this.field_150861_f = null;
					this.field_150868_h = 0;
				}
			}

			if (this.field_150861_f != null) {
				this.field_150862_g = this.func_150858_a();
			}
		}

		protected int func_180120_a(BlockPos p_180120_1_, EnumFacing p_180120_2_) {
			int i;

			for (i = 0; i < 22; ++i) {
				BlockPos blockpos1 = p_180120_1_.offset(p_180120_2_, i);

				if (!this.func_150857_a(this.world.getBlockState(blockpos1).getBlock()) || this.world.getBlockState(blockpos1.down()).getBlock() != ModBlocks.doopblock) {
					break;
				}
			}

			Block block = this.world.getBlockState(p_180120_1_.offset(p_180120_2_, i)).getBlock();
			return block == ModBlocks.doopblock ? i : 0;
		}

		protected int func_150858_a() {
			int i;
			label56:

			for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g) {
				for (i = 0; i < this.field_150868_h; ++i) {
					BlockPos blockpos = this.field_150861_f.offset(this.field_150866_c, i).up(this.field_150862_g);
					Block block = this.world.getBlockState(blockpos).getBlock();

					if (!this.func_150857_a(block)) {
						break label56;
					}

					if (block == ModBlocks.portalDoop) {
						++this.field_150864_e;
					}

					if (i == 0) {
						block = this.world.getBlockState(blockpos.offset(this.field_150863_d)).getBlock();

						if (block != ModBlocks.doopblock) {
							break label56;
						}
					}
					else if (i == this.field_150868_h - 1) {
						block = this.world.getBlockState(blockpos.offset(this.field_150866_c)).getBlock();

						if (block != ModBlocks.doopblock) {
							break label56;
						}
					}
				}
			}

			for (i = 0; i < this.field_150868_h; ++i) {
				if (this.world.getBlockState(this.field_150861_f.offset(this.field_150866_c, i).up(this.field_150862_g)).getBlock() != ModBlocks.doopblock) {
					this.field_150862_g = 0;
					break;
				}
			}

			if (this.field_150862_g <= 21 && this.field_150862_g >= 3) {
				return this.field_150862_g;
			}
			else {
				this.field_150861_f = null;
				this.field_150868_h = 0;
				this.field_150862_g = 0;
				return 0;
			}
		}

		protected boolean func_150857_a(Block p_150857_1_) {
			return p_150857_1_.getMaterial() == Material.air || p_150857_1_ == ModBlocks.doopFire || p_150857_1_ == ModBlocks.portalDoop;
		}

		public boolean func_150860_b() {
			return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
		}

		public void func_150859_c() {
			for (int i = 0; i < this.field_150868_h; ++i) {
				BlockPos blockpos = this.field_150861_f.offset(this.field_150866_c, i);

				for (int j = 0; j < this.field_150862_g; ++j) {
					this.world.setBlockState(blockpos.up(j), ModBlocks.portalDoop.getDefaultState().withProperty(BlockPortalDoop.AXIS, this.axis), 2);
				}
			}
		}
	}
}