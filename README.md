# M1-PRUEBA-SistemaDeClientes, notas:

Repositorio:
https://github.com/cabarcas/M1-PRUEBA-SistemaDeClientes

Pasos commit:
git init
#cambia el nombre de la Branch de: master a main. cambio necesario ya que gitHub por politicas cambio el nombre de la rama principal.
git config --global init.defaultBranch main
git config --global user.name carlos
git config --global user.mail casepulveda456@gmail.com
git commit -m "first commit"
git log

Pasos pushear cambios hacia repositorio remoto:
git branch -M main
git remote add origin https://github.com/cabarcas/M1-PRUEBA-SistemaDeClientes
git remote -v
git push -u origin main
ingresar nombre de usuario: nombre_usuario
ingresar constraseña -> enves de la clave colocar "personal access token"

#guardar token a la configuración local de git
git config --global credential.helper cache

#limpiar token del git local
git config --global --unset credential.helper

pom.xml:

incluye lombok para ver como se implementa a un proyecto java.
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>       
  <version>1.18.22</version>
  <scope>provided</scope>
</dependency>

inlcuye jansi para completar implementación de colores en la consola eclipse.
<!-- https://mvnrepository.com/artifact/org.fusesource.jansi/jansi -->
<dependency>
  <groupId>org.fusesource.jansi</groupId>
  <artifactId>jansi</artifactId>
	<version>2.4.0</version>
</dependency> 

 
proyecto:

se agrega ANSI Escape in Console al proyecto para mostrar colores en consola en función de la información de cada vista.

modelo: 
-clase Cliente dos versiones: 
estandar: atributos, geter/setter, constructores, toString y toStringColores
la misma usando lombok.

utilidades:
-agrega clase ConsoleColors con opciones de colores y color por defecto.
-agregan metodos:
 limpiezaDePantalla(int saltos)
 validaRut(String rut)
 dv(String rut)
 resetColores()
 anualidad(String anios)
 nombrePropio(String str)
 compruebaRuta(String ruta)

carpeta salidas:
contiene los enlaces directos a clientes txt y csv utilizados en el proyecto
cada acceso apunta a la ruta de ejemplo en el documento: c:\usuario\equipo\cesktop
se configuro asi para permitir al usuario probar otras rutas.

- M1_P_Salidas: variable patch apuntado a la ruta de ejemplo.
