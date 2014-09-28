/*
 * @author Gong Ke
 */

/**
 * The sparse array is an array list of linked lists.
 * Each linked entry holds both a grid occupant and a column index.
 * Each entry in the array list is a linked list or is null if that row is empty.
 */

public class SparseGridNode
{
    private Object occupant;
    private int col;
    private SparseGridNode next;
    /**
     * Constructs an SparseGridNode with parameter.
     */
    public SparseGridNode(Object occupant, int col, SparseGridNode next)
    {
        this.occupant = occupant;
        this.col = col;
        this.next = next;
    }
    /**
     * @return occupant
     */
    public Object getOccupant()
    {
        return occupant;
    }
    /**
     * @return col
     */
    public int getTheCol()
    {
        return col;
    }
    /**
     * @return next;
     */
    public SparseGridNode getNext()
    {
        return next;
    }

}
