//package BaseDeDatos;
//
//import java.sql.*;
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//
//public class MiniPracticaBD {
//
//	private static Logger logger = Logger.getLogger( "MiniPracticaBD" );
//	private static Connection con;
//	private static Statement s;
//	private static ResultSet rs;
//	public static void main(String[] args) {
//		String com = "";
//		try {
//			Class.forName( "org.sqlite.JDBC" );////Siempre igual
//			con = DriverManager.getConnection( "jdbc:sqlite:test.db" );////Siempre igual
//			s = con.createStatement();
//			try {
//				com = "create table Usuario( nick STRING, pass STRING )"; ////Creamos tabla de usuario
//				logger.log( Level.INFO, "BD: " + com );
//				s.executeUpdate( com );
//			} catch (SQLException e) {} // Se lanza si la tabla ya existe - no hay problema ////No se evita crear un if de control
//			// Ver si existe admin
//			com = "select * from Usuario where nick = 'admin'";
//			logger.log( Level.INFO, "BD: " + com );
//			rs = s.executeQuery( com );
//			if (!rs.next()) { // Añadirlo si no existe
//				com = "insert into Usuario ( nick, pass ) values ('admin', 'admin')";
//				logger.log( Level.INFO, "BD: " + com );
//				s.executeUpdate( com );
//			}
//			editarUsuarios();
//			/* Al final (cuando se cierre la ventana):
//			rs.close();
//			s.close();
//			con.close();
//			*/
//		} catch (SQLException|ClassNotFoundException e) {
//			System.out.println( "Último comando: " + com );
//			e.printStackTrace();
//		}
//	}
//	
//	private static JTextField tfUsuario = new JTextField( "", 10 );
//	private static JTextField tfPassword = new JTextField( "", 10 );
//	private static DefaultTableModel mUsuarios; // Modelo de datos para la JTable
//	private static JTable tUsuarios; // JTable de usuarios
//	private static JFrame ventana;
//	private static void editarUsuarios() {
//		// Inicializar tabla y modelo de tabla
//		Vector<String> cabeceras = new Vector<String>();
//		cabeceras.add( "nick" ); cabeceras.add( "pass" );
//		mUsuarios = new DefaultTableModel(  // Inicializa el modelo
//				new Vector<Vector<Object>>(),  // Datos de la jtable (vector de vectores)
//				cabeceras  // Cabeceras de la jtable
//				);
//		tUsuarios = new JTable( mUsuarios );
//		// Inicializar ventana
//		ventana = new JFrame( "Añadir usuarios" );
//		ventana.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
//		JPanel pSuperior = new JPanel( new BorderLayout() );
//		JPanel p = new JPanel();
//		p.add( new JLabel( "Nick: ") ); p.add( tfUsuario );
//		pSuperior.add( p, BorderLayout.NORTH );
//		p = new JPanel();
//		p.add( new JLabel( "Password: ") ); p.add( tfPassword );
//		pSuperior.add( p, BorderLayout.CENTER );
//		p = new JPanel();
//		JButton bAnyadir = new JButton( "Añadir usuario" );
//		p.add( bAnyadir );
//		JButton bBorrar = new JButton( "Borrar nick" );
//		JButton bListaUsuarios = new JButton( "Mostrar usuarios" );
//		JButton bBorrarContrase�a = new JButton( "Borrar contrase�as");
//		p.add( bBorrar );
//		p.add( bListaUsuarios );
//		p.add( bBorrarContrase�a );
//		pSuperior.add( p, BorderLayout.SOUTH );
//		ventana.add( pSuperior, BorderLayout.NORTH );  // Panel de datos al norte
//		ventana.add( new JScrollPane( tUsuarios ), BorderLayout.CENTER );  // JTable al center
//		ventana.pack();
//		ventana.setVisible( true );
//		bAnyadir.addActionListener( new ActionListener() { // Acción de añadir usuario
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (!tfUsuario.getText().isEmpty() && !tfPassword.getText().isEmpty()) {
//					String com = "";
//					try {
//						// Ver si existe usuario
//						// Si queremos asegurar el string habría que hacer algo así...
//						// String nick = tfUsuario.getText().replaceAll( "'", "''" );
//						// ...si no, cuidado con lo que venga en el campo de entrada.
//						// "select * from Usuario where nick = 'admin'";
//						com = "select * from Usuario where nick = '" + tfUsuario.getText() + "'";
//						logger.log( Level.INFO, "BD: " + com );
//						rs = s.executeQuery( com );
//						if (!rs.next()) {
//							// "insert into Usuario ( nick, pass ) values ('admin', 'admin')";
//							com = "insert into Usuario ( nick, pass ) values ('"+ 
//									tfUsuario.getText() +"', '" + tfPassword.getText() + "')";
//							logger.log( Level.INFO, "BD: " + com );
//							int val = s.executeUpdate( com );
//							if (val!=1) {
//								JOptionPane.showMessageDialog( ventana, "Error en inserción" );
//							}
//						} else {
//							JOptionPane.showMessageDialog( ventana, "Usuario " + tfUsuario.getText() + " ya existe" );
//						}
//					} catch (SQLException e2) {
//						System.out.println( "Último comando: " + com );
//						e2.printStackTrace();
//					}
//				} else {
//					JOptionPane.showMessageDialog( ventana, "Debes rellenar los dos campos" );
//				}
//				actualizaTabla();
//			}
//		});
//		bBorrar.addActionListener( new ActionListener() { // Acción de borrar usuario
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (!tfUsuario.getText().isEmpty() && !tfPassword.getText().isEmpty()) {
//					String com = "";
//					try {
//						// Borrar usuario
//						com = "delete from Usuario where nick = '"+ secu(tfUsuario.getText()) +"'";
//						logger.log( Level.INFO, "BD: " + com );
//						s.executeUpdate( com );
//					} catch (SQLException e2) {
//						System.out.println( "Último comando: " + com );
//						e2.printStackTrace();
//					}
//				} else {
//					JOptionPane.showMessageDialog( ventana, "Debes rellenar los dos campos" );
//				}
//				actualizaTabla();
//			}
//		});
//		
//		bListaUsuarios.addActionListener( new ActionListener() { // Accion de mostrar lista usuarios
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String com = "";
//				try {
//					com = "Select from Usuario";
//					logger.log( Level.INFO, "BD: " + com);
//					ResultSet rs = s.executeQuery( com );
//				while(rs.next()) {
//					System.out.println( "Usuarios" + rs.getString("nick") + "com password" + rs.getNString("pass"));
//				}
//				} catch( Exception e2 ) {
//					JOptionPane.showMessageDialog( ventana, "Error SQL" + com);
//				}
//			}
//			
//		});
//		
//		bBorrarContrase�a.addActionListener( new ActionListener() { // Accion de borrar contrase�a
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (!tfUsuario.getText().isEmpty() && !tfPassword.getText().isEmpty()) {
//					String com = "";
//					try {
//						// Borrar usuario
//						com = "delete from Password where pass = '"+ secu(tfPassword.getText()) +"'";
//						logger.log( Level.INFO, "BD: " + com );
//						s.executeUpdate( com );
//					} catch (SQLException e2) {
//						System.out.println( "Último comando: " + com );
//						e2.printStackTrace();
//					}
//				} else {
//					JOptionPane.showMessageDialog( ventana, "Debes rellenar los dos campos" );
//				}
//				actualizaTabla();
//			}
//		});
//		
////		ventana.addWindowListener( new WindowAdapter() {
////			@Override     
////			public void windowClosing(WindowEvent e) {
////				try {
////					rs.close();
////					s.close();
////					con.close();
////				} catch (SQLException e2) {
////					e2.printStackTrace();
////				}
////			}
////		});
////		// Actualiza por primera vez la tabla de usuarios en la BD
////		actualizaTabla();
////		}});
//	
//	private static void actualizaTabla() {
//		String com = "";
//		try {
//			while (mUsuarios.getRowCount()>0) mUsuarios.removeRow(0); // Vacía el modelo para volverlo a cargar de la bd
//			com = "select * from Usuario";
//			logger.log( Level.INFO, "BD: " + com );
//			rs = s.executeQuery( com );
//			while (rs.next()) {
//				String nick = rs.getString( "nick" );
//				String pass = rs.getString( "pass" );
//				Vector<String> fila = new Vector<>();
//				fila.add( nick ); fila.add( pass );
//				mUsuarios.addRow( fila );
//			}
//			tUsuarios.repaint();
//		} catch (SQLException e2) {
//			System.out.println( "Último comando: " + com );
//			e2.printStackTrace();
//		}
//	}
//
//	// Posible función de "securización" para evitar errores o ataques
//	private static String secu( String sqlInicial ) {
//		return sqlInicial;
//		// Si lo reemplazamos por esto, es mucho más seguro:
//		// return sqlInicial.replaceAll( "'", "" );
//	}
//}
//
//
//// OJO CON SQL INJECTION!!!!!
////
////  Por ejemplo si se mete en el nick esto y se da a borrar:
////   a'; drop table usuario; --
////
