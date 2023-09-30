/*Islands in a graph using BFS*/

import java.util.*;

class GFG
{


static final int R = 5;
static final int C = 5 ;
static class pair
{
	int first, second;
	public pair(int first, int second)
	{
		this.first = first;
		this.second = second;
	}
}


static boolean isSafe(int mat[][], int i, int j,
					boolean vis[][])
{
	return (i >= 0) && (i < R) &&
		(j >= 0) && (j < C) &&
		(mat[i][j]==1 && !vis[i][j]);
}

static void BFS(int mat[][], boolean vis[][],
				int si, int sj)
{


	int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };


	Queue<pair> q = new LinkedList<pair>();
	q.add(new pair(si, sj));
	vis[si][sj] = true;


	while (!q.isEmpty())
	{

		int i = q.peek().first;
		int j = q.peek().second;
		q.remove();

		// Go through all 8 adjacent
		for (int k = 0; k < 8; k++)
		{
			if (isSafe(mat, i + row[k],
					j + col[k], vis))
			{
				vis[i + row[k]][j + col[k]] = true;
				q.add(new pair(i + row[k], j + col[k]));
			}
		}
	}
}


static int countIslands(int mat[][])
{

	boolean [][]vis = new boolean[R][C];


	int res = 0;
	for (int i = 0; i < R; i++)
	{
		for (int j = 0; j < C; j++)
		{
			if (mat[i][j]==1 && !vis[i][j])
			{
				BFS(mat, vis, i, j);
				res++;
			}
		}
	}
	return res;
}

public static void main(String[] args)
{
	int mat[][] = { { 1, 1, 0, 0, 0 },
					{ 0, 1, 0, 0, 1 },
					{ 1, 0, 0, 1, 1 },
					{ 0, 0, 0, 0, 0 },
					{ 1, 0, 1, 0, 1 } };

	System.out.print(countIslands(mat));
}
}


