

package Recursividad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableCellRenderer;

import examen.ord202001.TablaAnalisis;
import examen.ord202001.VentanaTabla;
public class Apuntes {

}

//Dudas




//Básico

//public Nombre clase{ } constructor // main == main
//This => parametro fijo x, pasamos a un metodo x => this.x(la del método) = x (la fija).
//Si hacemos doble click a la izquierda, nos crea un punto de rotura, de manera que si le damos a debug, ejecuta hasta ese punto de rotura.
//Equals => Compara dos objetos
//Protected => Solo lo pueden heredar las clases hijas
//Polimorfismo => Heredar metodos de igual nombre, que pueden realizar funciones diferentes.
//Una clase abtracta => Una clase que no se puede instanciar.
//for each (recorrer una estructura lineal desde el primero hasta el último) => (Tipo elemento : nombreCualquiera : nombreElemento)
//Int => Tipo primitivo, Interger => Objeto
//leeYValidaEntero => (String mensaje, int valMinimo, int valMaximo, int valPorDefecto)
//this -> Hace referencia al objeto sobre el que estoy trabajando ( this.ventana, la que estoy usando ahora )
//.toUpperCase() -> Convierte qa mayusculas.


//Intermedio 2

//Clases internas -> Estan dentro de otras, de manera que tienen acceso a toda la informacion de aquellas a las que perternecen y pueden ser privadas. (Escuchadores por ejemplo).
//Clase anónima -> Una calse interna que se usa solo una vez.
	
	//1. En lugar de new objeto -> new clase Implementa o Hereda. (Autocompletar, recomendado).
	//2. Donde deseamoos crear el objeto ponemos { }.
	//3. No precisa nombre.

//SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss" ) Convierte la hora en ese formato. 
//Date nombre = new Date() -> sdf.format( nombre );


//Clase herencia - 1

//Conversión de un  objeto de juego inconcreto a un objeto de juego concreto (Pelota)
//Pelota pDentro = (Pelota) grupoPelotas.buscaPuntoEnObjetoJuegos( puls );
//El operador java instanceof se usa para probar si el objeto es una instancia del tipo especificado.
//if (grupoPelotas.buscaPuntoEnObjetoJuegos(puls) instanceof Pelota)
//"Cast" (Pelota),(Estrella).. no hay que hacer si en la clase padre existe el método (si existe dibujar, no hay que asegurarse que lo que dibujamos es una estrella)


//Clase herencia - 2 -> ArrayList

//ArrayList<Clase a referir> //Tamaño ilimitado (no hace falta definir al principio) 
//EJ. private ArrayList <ObjetosJuego> objetoJuego = null; // objetoJuego = new ArrayList<>();
//Tamaño del ArrayList .length =  .size()
//Modificar algo en el ArrrayList => set(posición,elelmento);
//Añadir algo en el ArrrayList => (.add(posicion,elemento)) Podemos indicar donde añadirlo o añadirlo al final
//Borrar un ArrayList .remove (posición) ("Adios") //Tambien podemos introducir un elemento (·), si esta lo borra (solo la primera vez), y si no no hace nada. (Si quisieramos borrar todos los elementos de una clase "removeall")
//Acceder a una posición del ArrayList => .get
//Buscar en un ArrayList, empieza por el principio y nos devuelve el primer elemento => .indexOf(objeto)  (lastindexOf => Por el final)
//IndexoOf => Para obtener la posición de un elemento de un ArrayList. (lastindexOf => el último) (Devuelve -1 si el elemento no exixte)
// Contains(boolean) => Si lo contiene true sino false.

//Clase herencia - 3 

//public class Estrella extends ObjetoJuego //Para heredar
//super(); llama al construcor del cual hereda; si no lo haces tu se hace automaticamente (Sucede dentro del constructor de la calse que hereda).


//Clase herencia - 4

//Llamar al metodo  toString de la clase padre => super.toString() 


//Clase herencia - 5

//Si defines un  metodo se ejecuta el tuyo, si no el de la clase padre.
//Si tenemos un ArrayList<objetos> solo podemos guardar objetos, no int,double,etc. => AraayList.add(new Interger,Double,Boolean,Character() );
//instanceof => comprueba si un elemento es de un tipo (EJ. object instanceof Integer)
//intValue, floatValue... os devuelve el valor del int, float...
//.getClass => me devuelve de que tipo es el obeto
//Interger.parseInt(String) => me convierte un String a entero, si esta bien escrito.


//Clase 1 

// this(), en vez de llamar al constructor de la clase padre, llamas a otro constructor de la misma clase.


//Clase 1 - Interfaces ("Herencia") (-able)

//Interface => No tiene datos, ni código, pero sí metodos (es abstracta)
//No hace falta poner abstract en los métodos de la interface
// implements Interface => Para "heredar" de la interface (Se pueden heredar de varias interfaces)
// instanceof interfaace (Para comprobar por ejemplo si se mueve)
//Los métodos de la interface son todos públicos.
//Las interfaces tambien puden heredar, si comparten métodos => interface nombre extends x,y...
//Una interface puede no tener código, puede solo heredar y servir de union.


//Clase 2 - Java Collection 

//Set => Objetos que no se repiten (HashSet y TreeSet)
//List => Cuando importa su posición (ArrayList)


//Clase 3 - HashSet

//Conjunto ordenado
//HashSet<String> nombre = new HashSet<String>();
//No existen repetiones
//.add => Para añadir (Aqui no hay posición, perteneces o no)
//.remove() => quitar
//.contais() => Contiene
//Se puede recorrer con un for each, para visualizar por ejemplo todas las palabras por pantalla


//Clase 3 - TreeSet

//Conjunto no ordenado
//Orden alfabético en Strings
//No existen repetiones
//.remove() => quitar
//.add => Para añadir (Aqui no hay posición, perteneces o no)
//.contais() => Contiene
//Se puede recorrer con un for each, para visualizar por ejemplo todas las palabras por pantalla


//Clase 4 - Mapa (Diccionario)

//Todo elemento tiene asociado una única clave.
//Esa clave permite añadir, buscar y borrar (En mucho menos tiempo)
//HashMap (no tiene orden) y TreeMap (tiene orden)
//Ejemplo => HashMap<String,Integer> nombre = new HashMap<Clave,Nombre>
//Añadir elementos a un mapa => nombre.put () (add en Arraylist)
//Recomendable Hash, tiene tiempo constasnte.
//Consultar => .get( clave ) (Devuelve el elemento asociado a la clave, no el elemento) (Null si elemento no exite)
//.containsKey => Por clave ( Se puede hacer por elemento pero no es reomendable)
//Eliminar => .remove (Puedes eliminar la clave y te elimina ambas)
//.keySet => Devuelve un conjunto de claves del mapa (Ya se puede recorrer, con un for each) (Obtener tambien el valor => String valor = mapaT.get( clave );)


//Clase 5 - (Tema 4 - ejemploVenta - OfertaProg2)

//Para guardar, ponemos arriba, donde la clase => ,Serializable (Si se hace en las hijas tambien ha de hacerse en la padre, ya que seguramente tambien querramos guardar sus valores.) (No soporta cambios en las clases)
//Número de serie por defecto, para evitar el error antes comentado ( private static final long serialVersionUID = 1L; ) (Versión uno, si se hacen cambios en las clases se suma uno (al de la clase modificada, no a todos) )
//22


//Clase 1 - Gestión de excepciones

//try{
//} catch ( Tipo de excepción (como si fuera un objeto) nombre ) { //Si hay error, aquí	
//}
//Seguimos si no hay error


//Clase 2 - Gestión de excepciones

//try{
//} catch ( Exception nombre ) { //Atrapa cualquier tipo de error (recomendado para el main) (Varias excepciones ..|..|..)
//}

//Clase 3 - Gestión de excepciones

//nombre.printStackTrace(); //muestra el tipo de error que es (al poner Exception)
//System.err.println () //Muestra en la consola de error, sale en rojo
//Gestionar varias excepciones ( NombreExcepcion | NombreExcepcion..) (No hay que poner subclases de excepciones, (por eso puede dar error, se quitan y ya) ).
//Se pueden hacer varios catch seguidos (El primero que se cumpla se ejecuta, solo uno), para tratar de diferentes maneras las distintas excepciones (Primero las más específicas (subclases) y luego las menos) : try{...}catch{...}catch{...}

//Clase 4 - Gestión de excepciones

//throws Excepciones { Este método puede ocurrir que lance alguna de estas excepciones, pero el compilador te obliga a registrarlas todas.
//Nunca encontraras errores, por que los delegas a quien te llama. (Si no me puedo ocupar del error en ese método lo uso).


//Clase 1  -  Ventanas

//ventana.setVisible(true);  //Se muestra la ventana. (False se oculta).
//Añadir código de gestión de evento -> Para que Swing (la ventana) pueda utilizar. (INSTANTANEOS)
//ventana.setLocation( x, y ) -> Posición de la ventana.
//EJEMPLO -> CAMBIODEVENTANAS

//Calse 2 - Ventana

//public class nombre extends JFrame -> Arriba al crear ventanas, ya que va a ser una ventana, con más cosas.
//Botones, cuadro de texto... -> Atributos
//BoxLayoutV o H -> Solo una columna, vertical o horizontalemnte.
//.revalidate() -> Cambiar en caliente el BorderLayout a otro Layout ( en caliente, en ejecución ). ( Sino se hace, y se cambia el layout de la ventana, hasta cambiar yo el tamaño de esta, no pasa nada).
//Al añadir elementos tambien es necesario hacer el .revalidate() (Por ejemplo un botón).
//.add() para añadir elementos (botones) .remove() para quitar un elemento y .removeAll() para quitar todos los elementos (En el contenedor en el que se encuentre el boton o elemento deseado).
//GridBagLayout -> Funciona como una matriz configurable (GridBagConstraintsv nombre = new GridBagConstraintsv )
//Posiciones absolutas -> Aunque variemos en tamaño de la ventana, siguen en el mismo lugar / Para poder hacer esto -> .setLayout( null );
//.setBounds( coordenadas y tamaño ) -> cuando el layout es nulo


//Calse 3 - Ventana

//JTextFiled( tamaño mínimo ) -> Cuadro de texto 
//JLabel -> Mensaje (texto).
//JTextArea(filas, caracteres de ancho) -> Caja de texto.
//ActionListener() -> Contenedor para estos elementos.

//Estructura recomendada para los constructores de las ventanas ( no main ):

 // 1. Configuración de la ventana

 // 2. Creación de contenedores (paneles) y componentes

 // 3. Asignación de componentes a contenedores

 // 4. Decoraciones (this.pack() -> Por ejemplo)

 // 5. Eventos (Ejemplo)
	//boton.addActionListener( new objeto );
	//Ese objeto ha de implementar ActionListener
	//Queremos pasarle código al botón, pero como no se puede, le psamos un objeto con ese código.

//this.pack() -> Dibuja la ventana con un tamaño mínimo, el necesario para que entre todo.


//Clase 4 - Ventana

//dispose()  cierra ventana 
//JScrollPane nombre = new JScrollPane( caja de texto ) ->para poder desplazarnos por ella con las felchas


//Clase 5 - Ventana (listenerMouse)

//MouseListener() -> Cuando pulsamos
//.setSelection( longitudTexto (nombre.getText().length) )
//MouseMotionListener -> Cuando no pulsamos
//Los listener de mouse -> Se crea ua clase interna con los listener y creamos un "objeto" que implementa a estas (autocompletar para ver sus métodos).


//Clase 6 - Ventana (ComponentListener)

//Si no deseo usar todos los métodos de un listener, basta con cambiar listener por Adapter, de manera que me quedo con aquellos que deseo.
//e.getSource, me indica que parte varia de tamaño.
//getWidth - getHeight (anchuara y altura) y getLocation (posicion).


//Clase 7 - Ventana (Eventos de teclado)

//setFocusable() -> Para que pueda pasar el foco del ratón o no.
//KeyListener -> Escuchadores de teclas.
//e.getKeyChar() -> Tecla que se escriba.
//e.getKeyCode() -> Tecla que no se escriba (control).
//e.cosume() -> Niega la orden


//Clase 8 - Ventana (FocusListener) 

//char letra = ...charAt(0) ->  Caracter 0 de una lista de estos.
//lugarDeseado.requestFocus() -> Reclama el foco


//Clase 9 - Ventana (WindowListener) 

//Activada, desactivada...


//Clase 1 - Hilo

//vent.setDefaultOperation( ) -> Acción que sucede al pulsar la x roja.
//Thread hilo = new Thread() -> Método run()
//Llamamos con -> hilo.start() 
//Hilos, código de gestion de eventos de mas de unos milisegundos.
//Thread.sleep( 1000 ); -> Duerme el hilo actual un segundo.

//Determina si el dinosaurio ha llegado a su posicón de destino, en caso afirmativo se detiene, si no se hubiese parado ya.


//Extra

//JProgressBar -> Ser añade aparte
//removeAll + revalidate, para cambiar panel.
//panel.setLayout( new BorderLayout() ); -> Sino te deja en visto
//Ejemplo init -> new int[] { vert[0].x, vert[1].x, vert[2].x },
//seleccionado = null; , recalculamos, repintamos.
///float <=

//addInternalFrameListener( new InternalFrameAdapter() {
//	
//	@Override
//	public void internalFrameActivated(InternalFrameEvent e) {
//		if (tablaDatos instanceof TablaAnalisis) {
//			TablaAnalisis tabalaAnalisis = (TablaAnalisis) tablaDatos;
//			if (tabalaAnalisis.getGrafico() != null) {
//				tabalaAnalisis.getGrafico().getJFrame().setVisible(true);
//			}
//		}
//		
//	}
//});
//tDatos.addMouseListener( new MouseAdapter() {
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		if (e.getClickCount()>=2) {
//			int fila = tDatos.rowAtPoint( e.getPoint() );
//			int columna = tDatos.columnAtPoint( e.getPoint() );
//			if (dobleClick!=null) dobleClick.evento( VentanaTabla.this, fila, columna );
//		}
//	}
//	//T5
//	int fila= -1; //-1 por que fila 0 existe.
//	int columna = -1; //-1 por que columna 0 existe.
//	@Override
//	public void mousePressed(MouseEvent e) {
//		fila = tDatos.rowAtPoint( e.getPoint() ); //Devuelve la fila en la cual se encuentra el rat�n.
//		columna = tDatos.columnAtPoint( e.getPoint()); //Devuelve la columna en la cual se encuentra el rat�n.
//	}
//	public void mouseReleased(MouseEvent e) {
//		int filaDestino = tDatos.rowAtPoint( e.getPoint());
//		int columnaDestino = tDatos.columnAtPoint( e.getPoint() );
//		if ( fila >= 0 && columna >= 0 && filaDestino >= 0 && columnaDestino >= 0) { //A habido un Pressed y ningun error.
//			Object o1 = tablaDatos.get(fila, columna);
//			Object o2 = tablaDatos.get(filaDestino, columnaDestino);
//			if (o1 != null && o2 != null && o1.getClass() == o2.getClass()) {
//				tablaDatos.set(fila, columna, o2);
//				tablaDatos.set(filaDestino, columnaDestino, o2);					}
//		}
//	}
//});

//tDatos.setDefaultRenderer( Object.class, new DefaultTableCellRenderer() {
//	Font font = new Font("Arial",Font.PLAIN, 14);
//	@Override
//	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//		c.setFont(font);
//		if(hasFocus) {
//			c.setForeground(Color.cyan);
//		} else if(isSelected) {
//			c.setForeground(Color.yellow);
//		} else {
//			c.setForeground(Color.black);
//		}
//		return c;
//	}
//});
