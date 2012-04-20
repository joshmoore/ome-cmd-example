OMERO Command Example
=====================
Open Microscopy Environment service template for extending server functionality
including new remoting types. Rather than providing an entire interface
implementation, this example adds an omero.cmd.Request type which can be passed
to submit().

Requirements
============

* OMERO 4.4.0 or later

Installation
============

Clone the repository in to your tools directory:

    cd openmicroscopy.git
    git clone git://github.com/openmicroscopy/ome-cmd-example components/tootls/MyCommand

    # Full build
    ./build.py

    # or just your command
    ./build.py -f components/tools/MyCommand/build.xml
    ./build.py -f components/tools/build.xml dist

If you would like to have place your CmdExample directory somewhere else, you will need
to modify one line in build.xml.

Now start up OMERO as normal and your service will be available. For clients to be able to use the new service,
however, they will need to be provided the artifacts built under tools/MyCommand/target

Next steps
==========

To further develop the sample code, run:

    ./build.py -f components/tools/MyCommand/build.xml eclipse

And then import the eclipse project. Feel free to fork the ome-cmd-example
repository and push your changes for discussion on the mailing list. Further,
you can rename the repository and the artifacts to have production ready
code.

See http://trac.openmicroscopy.org/ome/wiki/ExtendingOmero for more information.
