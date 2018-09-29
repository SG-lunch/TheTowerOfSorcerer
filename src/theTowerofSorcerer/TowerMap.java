package theTowerofSorcerer;

public class TowerMap 
{
	private Block[][] blocks;
	int upstairX,upstairY,downstairX,downstairY;
	public Block[][] getBlocks()
	{
		return blocks;
	}
	
	public TowerMap()
	{
		blocks = new Block[Lib.Row][Lib.Col];
	}
}

