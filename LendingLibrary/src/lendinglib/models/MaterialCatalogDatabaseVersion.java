package lendinglib.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

public class MaterialCatalogDatabaseVersion implements MaterialCatalogInterface {

	@Override
	public void addMaterial(Material newMaterial) {

		try {

			Class.forName("org.apache.derby.jdbc.ClientDriver");

			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/library")) {

				String sql;
				if (newMaterial instanceof Book) {
					sql = "insert into materials (barcode, title, author, isbn, branch, numberOfPages, type) values(?,?,?,?,?,?,'BOOK')";
					try (PreparedStatement stm = conn.prepareStatement(sql)) {

						Book newBook = (Book) newMaterial;

						stm.setString(1, newBook.getID());
						stm.setString(2, newBook.getTitle());
						stm.setString(3, newBook.getAuthor());
						stm.setString(4, newBook.getIsbn());
						stm.setString(5, "Any town of branch");
						stm.setInt(6, newBook.getNumberOfPages());

						int results = stm.executeUpdate();
						System.out.println("Records added:" + results);
					}

				} else if (newMaterial instanceof DVD) {
					sql = "insert into materials (barcode, title, branch, catalognumber, runningtime, licensed, type) values(?,?,?,?,?,?,'DVD')";
					try (PreparedStatement stm = conn.prepareStatement(sql)) {

						DVD newDVD = (DVD) newMaterial;

						stm.setString(1, newDVD.getID());
						stm.setString(2, newDVD.getTitle());
						stm.setString(3, "Any town of branch");
						stm.setString(4, newDVD.getCatalogNumber());
						stm.setInt(5, newDVD.getRunningTime());
						stm.setBoolean(6, newDVD.getLicence());

						int results = stm.executeUpdate();
						System.out.println("Records added:" + results);

					}
				}
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Something went wrong");
			System.out.println(e);

		} catch (SQLException e) {
			System.out.println("Something went wrong");
			System.out.println(e);

		}
	}

	@Override
	public TreeMap<String, Material> getMaterialMap() {
		// TODO Auto-generated method stub

		System.out.println("Return null pointer");
		return null;
	}

	@Override
	public Material findMaterial(String title) throws MaterialNotFoundException {

		try {

			Class.forName("org.apache.derby.jdbc.ClientDriver");

			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/library")) {

				try (Statement stm = conn.createStatement()) {

					try (ResultSet rs = stm
							.executeQuery("select * from materials where title like '%' + title + '%'")) {
						if (rs.next()) {
							String materialType = rs.getString("type");
							if (materialType.equalsIgnoreCase("BOOK")) {
								// add and return book
								Book newBook = new Book(rs.getString("barcode"), rs.getString("title"),
										rs.getString("author"), rs.getString("isbn"), rs.getString("branch"),
										rs.getInt("numberofpages"));
								return newBook;
							} else if (materialType.equalsIgnoreCase("DVD")) {
								DVD newDVD = new DVD(rs.getString("barcode"), rs.getString("title"),
										rs.getString("branch"), rs.getString("director"), rs.getString("catalogNo"),
										rs.getInt("runningtime"));
								return newDVD;
							} else {
								throw new MaterialNotFoundException();
							}

						} else {

							throw new MaterialNotFoundException();
						}
					}
				}
			}

		} catch (ClassNotFoundException e) {

			throw new RuntimeException(e);

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}

	@Override
	public int getNumberOfMaterials() {

		try {

			Class.forName("org.apache.derby.jdbc.ClientDriver");

			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/library")) {

				try (Statement stm = conn.createStatement()) {

					try (ResultSet rs = stm.executeQuery("select count(id) from materials")) {
						rs.next();
						return rs.getInt(1);
					}
				}
			}

		} catch (ClassNotFoundException e) {

			throw new RuntimeException(e);

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}
	}
}
