## Documentation pour l'utilisation d'OpenORB dans eclipse

### Les étapes

 * Ajout des libraires OpenORB au projet Java
 * Ajout d'une configuration pour la compilation du contrat idl
 * Ajout d'une configuration pour l'exécution du naming service
 * Ajout d'une configuration pour l'exécution des classes Java


### Ajout des libraires OpenORB au projet Java

clic droit projet >> properties
menu Java Build Path
onglet Libraries
bouton add Jar

liste (fichiers dans le dossier lib):
 * openorb-1.3.1.jar
 * openorb_tools-1.3.1.jar
 * avalon-framework.jar
 * logkit.jar

### Ajout d'une configuration pour la compilation du contrat idl

clic droit sur le projet >> Run As >> Run configurations
Nouvelle Java Applications Configuration

Paramètres:

	Name -> compilation IDL
	Main Class -> org.openorb.compiler.IdlCompiler
	coché les deux options include
	Arguments >> Program Arguments
	 -> src/LivreEnLigne.idl -verbose -d ./src

### Ajout d'une configuration pour l'exécution du naming service


clic droit sur le projet >> Run As >> Run configurations
Nouvelle Java Applications Configuration


Paramètres:
	Name -> serveur de nommage
	Main Class -> org.openorb.util.MapNamingContext

	Arguments >>
		 Program Arguments
	 	-> -ORBPort=2001 -print
		Vm arguments
		-> -Dorg.omg.CORBA.ORBClass=org.openorb.CORBA.ORB

### Ajout d'une configuration pour l'exécution des classes Java

	Name -> <nom Classe>
	Main Class -> <package>/<nom classe>

	Arguments >>
		Vm arguments
		-> -Dorg.omg.CORBA.ORBClass=org.openorb.CORBA.ORB
