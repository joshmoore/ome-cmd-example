#
#   Copyright 2012 Glencoe Software, Inc. All rights reserved.
#   Use is subject to license terms supplied in LICENSE.txt
#

import sys, os
try:
    blitz = os.environ["BLITZ_COMPONENT_DIR"]
except KeyError:
    blitz = os.path.abspath( os.path.join(os.path.curdir, os.path.pardir, os.path.pardir, "blitz") )
sys.path.append( blitz )
from blitz_tools import *

env = OmeroEnvironment()
env.Repository(["generated", "resources"])
env.Append(CPPPATH=["generated",tools_include])

if os.environ.has_key("NOMAKE"):
    build_cpp = False
elif not env.GetOption('clean'):
    conf = Configure(env)
    build_cpp = conf.CheckLibWithHeader("omero_client", "omero/ClientErrors.h", "C++")
    conf.Finish()
else:
    build_cpp = False

#
# Defining CmdExample version of DEPMAP.
#
env["DEPMAP"] = {
    #"omero/YourAPIHere.java" : "omero/YourClassHere.java",
}

#
# Redefining the common method
#
orig_common = common
def common(dir = generated):
    orig = orig_common(dir)
    return ["-I%s" % blitz_resources, "-I%s" % blitz_generated] + orig
import blitz_tools
blitz_tools.common = common

#
# Call slice2java, slice2cpp, and slice2py
#

actions = []
for m in methods:
    for w in where:
        for d in directories:
            action = m(env, w, d)
            actions.extend( action )

env.Alias("slice", actions)

#
# Build library
#
if build_cpp:
    lib = env.SharedLibrary("omero_CmdExample",
        ["omero/CmdExampleAPI.cpp"],
        LIBS=env.icelibs()+["omero_client"])

    env.Alias("lib", lib)
    env.Depends(lib, "slice")

    install = env.Install('../target/lib', lib)
    env.Alias('install', install)
else:
    # Defining essentially no-ops
    env.Alias('lib', 'slice')
    env.Alias('install', 'slice')
