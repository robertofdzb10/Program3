package baseDeDatosDeberes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatos {
	private static Connection conexion;
	
	/** Abre conexi贸n con la base de datos
	 * @param nombreBD	Nombre del fichero de base de datos
	 * @return	true si la conexi贸n ha sido correcta, false en caso contrario
	 */
	public static boolean abrirConexion( String nombreBD ) {
		try {
			System.out.println( "Conexi贸n abierta" );
			Class.forName("org.sqlite.JDBC");  // Carga la clase de BD para sqlite
			conexion = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			
			/*
			// No lo pide el ejercicio, pero si se quiere crear la base de datos si no existe desde el propio programa habr铆a que hacer esto:
			// creaci贸n bd
			Statement statement = conexion.createStatement();
			String sent = "CREATE TABLE IF NOT EXISTS producto (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre varchar(100), precio real);";
			System.out.println( sent );
			statement.executeUpdate( sent );
			sent = "CREATE TABLE IF NOT EXISTS compra (id INTEGER PRIMARY KEY AUTOINCREMENT, idProducto int, fecha bigint, cantidad int);";
			System.out.println( sent );
			statement.executeUpdate( sent );
			try {
				sent = "insert into producto (id, nombre, precio) values (1,'Jam贸n para profesor',345);";
				System.out.println( sent );
				statement.executeUpdate( sent );
				sent = "insert into producto (id, nombre, precio) values (2,'Crucifijo rezos pre-examen',42);";
				System.out.println( sent );
				statement.executeUpdate( sent );
				sent = "insert into producto (id, nombre, precio) values (3,'Asesor programaci贸n Java (hora)',25);";
				System.out.println( sent );
				statement.executeUpdate( sent );
			} catch(Exception e) {}  // Es normal que haya error en los inserts si ya existen las claves
			// fin creaci贸n 
			*/
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/** Cierra la conexi贸n abierta de base de datos ({@link #abrirConexion(String)})
	 */
	public static void cerrarConexion() {
		try {
			conexion.close();
			System.out.println( "Conexi贸n cerrada" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Lee los productos de la conexi贸n de base de datos abierta
	 * @return	Lista completa de productos, null si hay alg煤n error
	 */
	public static ArrayList<Producto> getProductos() {
		try {
			Statement statement= conexion.createStatement(); //Abrimos conexi髇
			ArrayList<Producto> producto = new ArrayList<Producto>();
			String ssql = "select * from producto = ";
//			ssql = ssql + "";
//			ssql = ssql + dato;
//			ssql = ssql + "";
			ResultSet rs = statement.executeQuery("select * from producto;"); //from producto where id = a lo que quieras
			while (rs.next()) {
				System.out.println((rs.getInt("id")));
			}
			statement.close();//Cerramos conexi髇
			return producto;
		}  catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

//	private static void ArrayList<>() {
//		// TODO Auto-generated method stub
//		
//	}

	/** Inserta una compra en la base de datos abierta
	 * Actualiza el id de la compra insertada
	 * @param compra	Compra a insertar
	 * @return	true si la inserci贸n es correcta, false en caso contrario
	 */
	public static boolean insertarCompra( Compra compra ) {
		// TODO
		return false;
	}
	
	/** Lee las compras de un producto dado de la conexi贸n de base de datos abierta
	 * @return	Lista completa de compras de ese producto, vac铆a si no hay ninguna, null si hay alg煤n error
	 */
	public static ArrayList<Compra> getCompras( Producto producto ) {
		// TODO
		return null;
	}

	/** Borra una compra en la base de datos abierta
	 * @param compra	Compra a borrar
	 * @return	true si el borrado es correcto, false en caso contrario
	 */
	public static boolean borrarCompra( Compra compra ) {
		// TODO
		return false;
	}
	
	
}
