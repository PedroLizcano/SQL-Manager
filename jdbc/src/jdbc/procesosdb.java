package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class procesosdb {
	private static PreparedStatement preparedStatement;
	private static Connection connection;
	static Scanner teclado = new Scanner(System.in);
	public static  void menu () throws SQLException{
		int opc;
		do {
			System.out.println("-----Opciones--------");
			System.out.println("-----1.Insertar------");
			System.out.println("-----2.Eliminar------");
			System.out.println("-----3.Modificar-----");
			System.out.println("-----4.Visualizar----");
			System.out.println("-----5.Salir---------");
			System.out.println("---escribe una opción---");
			opc=teclado.nextInt();
			switch(opc){
			case 1:
				insertar(); 
				break;
			case 2:
				eliminar();
				break;
			case 3:
				modificar();
				break;
			case 4:
				visualizar();
				break;
			}
		}while(opc<4 & opc>0);
	}
	public static void eliminar() { 
		String cadena;
		int numero;
		int opc;
		System.out.println("que campo deseas escribir para eliminar");
		System.out.println("1.id");
		System.out.println("2.nombre");
		System.out.println("3.apellido");
		System.out.println("4.curso");
		System.out.println("5.fecha_nacimiento");
		System.out.println("escribe una opcion");
		opc=teclado.nextInt();
		switch(opc) {
		case 1:
			try {

				conectarBbdd();
				System.out.println("escribe el id de la persona que quieres eliminar");
				numero=teclado.nextInt();
				String query = "delete from alumnos1 where id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, numero);
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;
		case 2:
			try {

				conectarBbdd();
				System.out.println("escribe el nombre de la persona que quieres eliminar");
				cadena=teclado.next();
				String query = "delete from alumnos1 where nombre = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, cadena);
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;
		case 3:
			try {

				conectarBbdd();
				System.out.println("escribe el apellido de la persona que quieres eliminar");
				cadena=teclado.next();
				String query = "delete from alumnos1 where apellidos = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, cadena);
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;
		case 4:
			try {

				conectarBbdd();
				System.out.println("escribe el curso de las personas que quieres eliminar");
				cadena=teclado.next();
				String query = "delete from alumnos1 where grupo = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, cadena);
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;
		case 5:
			try {

				conectarBbdd();
				System.out.println("escribe la fecha de nacimiento(YYYY-MM-DD) de la persona que quieres eliminar");
				cadena=teclado.next();
				String query = "delete from alumnos1 where fecha = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, cadena);
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
			break;
		}
	}
	private static void conectarBbdd() throws SQLException {

		String url = "jdbc:mysql://localhost:3306/agenda?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		connection = DriverManager.getConnection(url, "root", "gmq2019");
	}
	public static void modificar() {
		String cadena;
		String cadena1;
		int numero;
		int id;
		int opc;
		int opc2;
		System.out.println("que campo quieres modificar");
		System.out.println("1.id");
		System.out.println("2.nombre");
		System.out.println("3.apellido");
		System.out.println("4.curso");
		System.out.println("5.fecha_nacimiento");
		System.out.println("escribe una opcion");
		opc=teclado.nextInt();
		switch(opc){
		case 1:
			System.out.println("escribe el id que quieres escribir");
			id=teclado.nextInt();
			System.out.println("modificar id dando como parametro:");
			System.out.println("1.id");
			System.out.println("2.nombre");
			System.out.println("3.apellido");
			System.out.println("4.curso");
			System.out.println("5.fecha(YYYY-MM-DD)");
			System.out.println("escribe la opcion");
			opc2=teclado.nextInt();
			switch(opc2) {
			case 1:
				try {
					conectarBbdd();
					System.out.println("escribe el id de la persona que quieras modificar");
					numero=teclado.nextInt();
					String query = "update alumnos1 set id="+id+" where id=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, numero);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 2:
				try {
					conectarBbdd();
					System.out.println("escribe el nombre de la persona que quieras modificar");
					cadena=teclado.next();
					String query = "update alumnos1 set id="+id+" where nombre=?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1,cadena);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 3:
				try {
					conectarBbdd();
					System.out.println("escribe el apellido de la persona que quieras modificar");
					cadena=teclado.next();
					String query = "update alumnos1 set id="+id+" where apellidos=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 4:
				try {
					conectarBbdd();
					System.out.println("escribe el curso de la persona que quieras modificar");
					cadena=teclado.next();
					String query = "update alumnos1 set id="+id+" where grupo=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 5:
				try {
					conectarBbdd();
					System.out.println("escribe la fecha(YYYY-MM-DD) de la persona que quieras modificar");
					cadena=teclado.next();
					String query = "update alumnos1 set id="+id+" where fecha=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			}

			break;

		case 2:
			System.out.println("escribe el nombre que quieres escribir");
			cadena=teclado.next();
			System.out.println("modificar nombre dando como parametro:");
			System.out.println("1.id");
			System.out.println("2.nombre");
			System.out.println("3.apellido");
			System.out.println("4.curso");
			System.out.println("5.fecha(YYYY-MM-DD)");
			System.out.println("escribe la opcion");
			opc2=teclado.nextInt();
			switch(opc2) {
			case 1:
				try {
					conectarBbdd();
					System.out.println("escribe el id de la persona que quieras modificar");
					numero=teclado.nextInt();
					String query = "update alumnos1 set nombre= '"+cadena+"' where id=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, numero);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				break;
			case 2:
				try {
					conectarBbdd();
					System.out.println("escribe el nombre de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set nombre= '"+cadena+"' where nombre=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 3:
				try {
					conectarBbdd();
					System.out.println("escribe el apellido de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set nombre= '"+cadena+"' where apellidos=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 4:
				try {
					conectarBbdd();
					System.out.println("escribe el grupo de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set nombre= '"+cadena+"' where grupo=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 5:
				try {
					conectarBbdd();
					System.out.println("escribe la fecha de nacimiento(YYYY-MM-DD) de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set nombre= '"+cadena+"' where fecha=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			}

			break;
		case 3:
			System.out.println("escribe el apellido que quieres escribir");
			cadena=teclado.next();
			System.out.println("modificar nombre dando como parametro:");
			System.out.println("1.id");
			System.out.println("2.nombre");
			System.out.println("3.apellido");
			System.out.println("4.curso");
			System.out.println("5.fecha(YYYY-MM-DD)");
			System.out.println("escribe la opcion");
			opc2=teclado.nextInt();
			switch(opc2) {
			case 1:
				try {
					conectarBbdd();
					System.out.println("escribe el id de la persona que quieras modificar");
					numero=teclado.nextInt();
					String query = "update alumnos1 set apellidos= '"+cadena+"' where id=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, numero);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				break;
			case 2:
				try {
					conectarBbdd();
					System.out.println("escribe el nombre de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set apellidos= '"+cadena+"' where nombre=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 3:
				try {
					conectarBbdd();
					System.out.println("escribe el apellido de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set apellidos= '"+cadena+"' where apellidos=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 4:
				try {
					conectarBbdd();
					System.out.println("escribe el grupo de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set apellidos= '"+cadena+"' where grupo=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 5:
				try {
					conectarBbdd();
					System.out.println("escribe la fecha de nacimiento(YYYY-MM-DD) de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set apellidos= '"+cadena+"' where fecha=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			}

			break;
		case 4:
			System.out.println("escribe el curso que quieres escribir");
			cadena=teclado.next();
			System.out.println("modificar nombre dando como parametro:");
			System.out.println("1.id");
			System.out.println("2.nombre");
			System.out.println("3.apellido");
			System.out.println("4.curso");
			System.out.println("5.fecha(YYYY-MM-DD)");
			System.out.println("escribe la opcion");
			opc2=teclado.nextInt();
			switch(opc2) {
			case 1:
				try {
					conectarBbdd();
					System.out.println("escribe el id de la persona que quieras modificar");
					numero=teclado.nextInt();
					String query = "update alumnos1 set grupo= '"+cadena+"' where id=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, numero);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				break;
			case 2:
				try {
					conectarBbdd();
					System.out.println("escribe el nombre de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set grupo= '"+cadena+"' where nombre=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 3:
				try {
					conectarBbdd();
					System.out.println("escribe el apellido de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set grupo= '"+cadena+"' where apellidos=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 4:
				try {
					conectarBbdd();
					System.out.println("escribe el grupo de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set grupo= '"+cadena+"' where grupo=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 5:
				try {
					conectarBbdd();
					System.out.println("escribe la fecha de nacimiento(YYYY-MM-DD) de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set grupo= '"+cadena+"' where fecha=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			}

			break;
		case 5:
			System.out.println("escribe la fecha de nacimiento(YYYY-MM-DD) que quieres escribir");
			cadena=teclado.next();
			System.out.println("modificar nombre dando como parametro:");
			System.out.println("1.id");
			System.out.println("2.nombre");
			System.out.println("3.apellido");
			System.out.println("4.curso");
			System.out.println("5.fecha(YYYY-MM-DD)");
			System.out.println("escribe la opcion");
			opc2=teclado.nextInt();
			switch(opc2) {
			case 1:
				try {
					conectarBbdd();
					System.out.println("escribe el id de la persona que quieras modificar");
					numero=teclado.nextInt();
					String query = "update alumnos1 set fecha= '"+cadena+"' where id=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, numero);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				break;
			case 2:
				try {
					conectarBbdd();
					System.out.println("escribe el nombre de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set fecha= '"+cadena+"' where nombre=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 3:
				try {
					conectarBbdd();
					System.out.println("escribe el apellido de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set fecha= '"+cadena+"' where apellidos=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 4:
				try {
					conectarBbdd();
					System.out.println("escribe el grupo de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set fecha= '"+cadena+"' where grupo=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case 5:
				try {
					conectarBbdd();
					System.out.println("escribe la fecha de nacimiento(YYYY-MM-DD) de la persona que quieras modificar");
					cadena1=teclado.next();
					String query = "update alumnos1 set fecha= '"+cadena+"' where fecha=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cadena1);
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			}

			break;
		}

	}
	public static void insertar() {
		int id;
		String nombre;
		String apellido;
		String curso;
		String fecha;

		try {
			conectarBbdd();
			System.out.println("insertar");
			System.out.println("escribe el id");
			id=teclado.nextInt();
			System.out.println("escribe el nombre");
			nombre=teclado.next();
			System.out.println("escribe el apellido");
			apellido=teclado.next();
			System.out.println("escribe el curso");
			curso=teclado.next();
			System.out.println("escribe la fecha de nacimiento('YYYY'-'MM'-'DD'");
			fecha=teclado.next();
			String query = "insert into alumnos1 values (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, nombre);
			preparedStatement.setString(3, apellido);
			preparedStatement.setString(4, curso);
			preparedStatement.setString(5, fecha);
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
			System.out.println("insertado correctamente");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	public static void visualizar() throws SQLException {
		String cadena;
		int id,opc;
		String sql;

		System.out.println("visualizar alumno dando como parametro:");
		System.out.println("1.id");
		System.out.println("2.nombre");
		System.out.println("3.apellido");
		System.out.println("4.curso");
		System.out.println("5.fecha(YYYY-MM-DD)");
		System.out.println("6.ordenador por id");
		System.out.println("7.ordenador por nombre");
		System.out.println("8.ordenador por apellidos");
		System.out.println("9.ordenador por curso");
		System.out.println("10.ordenador por fecha");
		System.out.println("escribe la opcion");
		opc=teclado.nextInt();

		if(opc==1) {
			conectarBbdd();
			Statement statement = connection.createStatement();
			System.out.println("escribe el id de la persona que deseas ver");
			id=teclado.nextInt();
			sql = "select * from alumnos1 where id='"+id+"'";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println("ALUMNO:");
				System.out.println("Id: " + resultSet.getInt(1));
				System.out.println("Nombre: " + resultSet.getString(2));
				System.out.println("Apellidos: " + resultSet.getString(3));
				System.out.println("Grupo: " + resultSet.getString(4));
				System.out.println("Fecha de nacimiento: " + resultSet.getDate(5));
				System.out.println();
			}
			resultSet.close();
			statement.close();
			connection.close();
		}

		if(opc==2) {
			conectarBbdd();
			Statement statement = connection.createStatement();
			System.out.println("escribe el nombre de la persona que deseas ver");
			cadena=teclado.next();
			sql = "select * from alumnos1 where nombre='"+cadena+"'";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println("ALUMNO:");
				System.out.println("Id: " + resultSet.getInt(1));
				System.out.println("Nombre: " + resultSet.getString(2));
				System.out.println("Apellidos: " + resultSet.getString(3));
				System.out.println("Grupo: " + resultSet.getString(4));
				System.out.println("Fecha de nacimiento: " + resultSet.getDate(5));
				System.out.println();
			}
			resultSet.close();
			statement.close();
			connection.close();
		}

		if(opc==3) {
			conectarBbdd();
			Statement statement = connection.createStatement();
			System.out.println("escribe los apellidos de la persona que deseas ver");
			cadena=teclado.next();
			sql = "select * from alumnos1 where apellidos='"+cadena+"'";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println("ALUMNO:");
				System.out.println("Id: " + resultSet.getInt(1));
				System.out.println("Nombre: " + resultSet.getString(2));
				System.out.println("Apellidos: " + resultSet.getString(3));
				System.out.println("Grupo: " + resultSet.getString(4));
				System.out.println("Fecha de nacimiento: " + resultSet.getDate(5));
				System.out.println();
			}
			resultSet.close();
			statement.close();
			connection.close();
		}

		if(opc==4) {
			conectarBbdd();
			Statement statement = connection.createStatement();
			System.out.println("escribe el curso de la persona que deseas ver");
			cadena=teclado.next();
			sql = "select * from alumnos1 where grupo='"+cadena+"'";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println("ALUMNO:");
				System.out.println("Id: " + resultSet.getInt(1));
				System.out.println("Nombre: " + resultSet.getString(2));
				System.out.println("Apellidos: " + resultSet.getString(3));
				System.out.println("Grupo: " + resultSet.getString(4));
				System.out.println("Fecha de nacimiento: " + resultSet.getDate(5));
				System.out.println();
			}
			resultSet.close();
			statement.close();
			connection.close();
		}

		if(opc==5) {
			conectarBbdd();
			Statement statement = connection.createStatement();
			System.out.println("escribe la fecha de la persona que deseas ver");
			cadena=teclado.next();
			sql = "select * from alumnos1 where fecha='"+cadena+"'";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println("ALUMNO:");
				System.out.println("Id: " + resultSet.getInt(1));
				System.out.println("Nombre: " + resultSet.getString(2));
				System.out.println("Apellidos: " + resultSet.getString(3));
				System.out.println("Grupo: " + resultSet.getString(4));
				System.out.println("Fecha de nacimiento: " + resultSet.getDate(5));
				System.out.println();
			}
			resultSet.close();
			statement.close();
			connection.close();
			menu();
		}
		if(opc==6) {
			conectarBbdd();
			Statement statement = connection.createStatement();
			System.out.println("ordenado por id");
			
			sql = "select * from alumnos1 order by id";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println("ALUMNO:");
				System.out.println("Id: " + resultSet.getInt(1));
				System.out.println("Nombre: " + resultSet.getString(2));
				System.out.println("Apellidos: " + resultSet.getString(3));
				System.out.println("Grupo: " + resultSet.getString(4));
				System.out.println("Fecha de nacimiento: " + resultSet.getDate(5));
				System.out.println();
			}
			resultSet.close();
			statement.close();
			connection.close();
			menu();
		}
		if(opc==7) {
			conectarBbdd();
			Statement statement = connection.createStatement();
			System.out.println("ordenado por nombres");
			
			sql = "select * from alumnos1 order by nombre";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println("ALUMNO:");
				System.out.println("Id: " + resultSet.getInt(1));
				System.out.println("Nombre: " + resultSet.getString(2));
				System.out.println("Apellidos: " + resultSet.getString(3));
				System.out.println("Grupo: " + resultSet.getString(4));
				System.out.println("Fecha de nacimiento: " + resultSet.getDate(5));
				System.out.println();
			}
			resultSet.close();
			statement.close();
			connection.close();
			menu();
		}
		if(opc==8) {
			conectarBbdd();
			Statement statement = connection.createStatement();
			System.out.println("ordenado por apellido");
			
			sql = "select * from alumnos1 order by apellidos";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println("ALUMNO:");
				System.out.println("Id: " + resultSet.getInt(1));
				System.out.println("Nombre: " + resultSet.getString(2));
				System.out.println("Apellidos: " + resultSet.getString(3));
				System.out.println("Grupo: " + resultSet.getString(4));
				System.out.println("Fecha de nacimiento: " + resultSet.getDate(5));
				System.out.println();
			}
			resultSet.close();
			statement.close();
			connection.close();
			menu();
		}
		if(opc==9) {
			conectarBbdd();
			Statement statement = connection.createStatement();
			System.out.println("ordenado por curso");
			
			sql = "select * from alumnos1 order by grupo";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println("ALUMNO:");
				System.out.println("Id: " + resultSet.getInt(1));
				System.out.println("Nombre: " + resultSet.getString(2));
				System.out.println("Apellidos: " + resultSet.getString(3));
				System.out.println("Grupo: " + resultSet.getString(4));
				System.out.println("Fecha de nacimiento: " + resultSet.getDate(5));
				System.out.println();
			}
			resultSet.close();
			statement.close();
			connection.close();
			menu();
		}
		if(opc==10) {
			conectarBbdd();
			Statement statement = connection.createStatement();
			System.out.println("ordenador por fecha de nacimiento ");
			
			sql = "select * from alumnos1 order by fecha";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println("ALUMNO:");
				System.out.println("Id: " + resultSet.getInt(1));
				System.out.println("Nombre: " + resultSet.getString(2));
				System.out.println("Apellidos: " + resultSet.getString(3));
				System.out.println("Grupo: " + resultSet.getString(4));
				System.out.println("Fecha de nacimiento: " + resultSet.getDate(5));
				System.out.println();
			}
			resultSet.close();
			statement.close();
			connection.close();
			menu();
		}

	}

}

