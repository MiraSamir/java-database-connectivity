package dbms;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import dataTypes.TypeException;

/**
 * The Interface ITableColumn.
 */
public interface ITableColumn {
	
	/**
	 * Rearrange column. Rearranges column names and column values (parameters
	 * passed to TableColumn constuctor) according to their order in
	 * TableIdentifier. ==> inserts null values infront of empty column values
	 * ****Mainly used to write rows in XMLFile
	 * 
	 * @return the arranged array list in the form of [[Name, age],[varchar,
	 *         int]]
	 */
	public ArrayList<ArrayList<String>> rearrangeColumn();
	
	/**
	 * Checks for valid identifiers. Checks whether column names and values
	 * inserted in (FOR EXAMPLE: INSERT QUERY)
	 * 
	 * @param ===>
	 *            uses column names and column values inserted in initializing
	 *            tableColumn are valid/ same size / if no column names then
	 *            column values same size of column identifiers
	 * @return true, if successful
	 * @throws XMLStreamException
	 *             the XML stream exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TypeException
	 * @throws DatabaseException
	 */
	public boolean hasValidIdentifiers() throws XMLStreamException, IOException, TypeException, DatabaseException;
	
	/**
	 *
	 * @return
	 * @throws XMLStreamException
	 * @throws IOException
	 * @throws DatabaseException
	 */
	
	public ArrayList<ArrayList<String>> getColumnIdentifiers()
			throws XMLStreamException, IOException, DatabaseException;
	
	/**
	 *
	 * @param where
	 * @return
	 * @throws XMLStreamException
	 * @throws IOException
	 * @throws TypeException
	 * @throws DatabaseException
	 */
	public boolean isValidQuery(String[] where)
			throws XMLStreamException, IOException, TypeException, DatabaseException;
	
	/**
	 * 
	 * @param columnName
	 * @return
	 * @throws XMLStreamException
	 * @throws IOException
	 * @throws DatabaseException
	 */
	
	public String getColumnType(String columnName) throws XMLStreamException, IOException, DatabaseException;
	
	/**
	 * @return
	 * @throws XMLStreamException
	 * @throws IOException
	 * @throws DatabaseException
	 */
	public boolean isColumnNameUnique() throws XMLStreamException, IOException, DatabaseException;
	
	/**
	 * 
	 * @throws DatabaseException
	 */
	public void isDuplicate() throws DatabaseException;
	
}