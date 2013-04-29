ECP-Demos
=========

Demo features for ECP

Setup
=========
1. Download the Eclipse Modeling Tools from here: http://www.eclipse.org/downloads/packages/eclipse-modeling-tools/junosr2
2. In your Eclipse go to Help->Install New Software
	2.1 Install the EMFStore using this update site: http://download.eclipse.org/emf-store/milestones/latest (select all features)
	2.2 Install the EMFCP using this update site: http://download.eclipse.org/emfclient/milestones/100RC2 (select all features)
	Optional:
	2.3 Install the PShelf widget from this update site: http://download.eclipse.org/technology/nebula/snapshot (just PShelf)
3. Import the Sources from git
4. Go to Run->Run Configurations
	4.1 Select "Eclipse Application" and create a new
	4.2 Give it a meaningful name
	4.3 Select "Run an application" and there the "org.eclipse.emf.ecp.application.e3.application"
	4.4 Hit "Apply"
5. Run the application
