# Pre-requirements #

  1. [JDK 6 Update xx](http://java.sun.com/javase/downloads/index.jsp)
  1. [Tomcat 6.x zipeed core](http://tomcat.apache.org/download-60.cgi)
  1. [MySQL Server 5.1](http://dev.mysql.com/downloads/mysql/5.1.html#downloads) (Notice, that you can actually use any db you want but you must fix all necessary configuration files and pom.xml to do so. We will add a guide about this later.)
  1. [Eclipse 3.4 IDE for Java EE Developers](http://www.eclipse.org/downloads/packages/release/ganymede/sr2)
  1. [m2eclipse plugin for eclipse](http://m2eclipse.sonatype.org/)
  1. [Lombok plugin for elclipse](http://projectlombok.org/)
  1. Optional. [Subclipse plugin for eclipse](http://subclipse.tigris.org/)
  1. Optional. [MySQL GUI Tools](http://dev.mysql.com/downloads/gui-tools/5.0.html)

# Setting up environment #

  1. Download, unpack/install all dependencies
    * Use UTF8 as default character set for MySql server
  1. MySql server configuration:
    * Create new database 'infirmarium'
    * Add new DB user. Username: root; Password: root.
    * Assign all privileges for user 'root' in database 'infirmarium' (Not checked. All must work even without this step)
  1. Checkout project from svn.
  1. Run **clean install** goal on infirmarium project.
  1. Run mvn **gwt:run** on infiramrium-client project to run.