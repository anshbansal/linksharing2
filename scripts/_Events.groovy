eventCompileStart = {kind ->
    // Ants Project is available via: kind.ant.project
    updateJavascriptDependencies()
    // Obtain status and output
}
 
private void updateJavascriptDependencies(){
    println "| Load js dependencies from cache..."
    def proc = "./node_modules/.bin/bower update --quiet -o".execute()
    proc.waitFor()

    if(proc.exitValue()!=0){
        println "| Error occured while loading dependencies from local cache : ${proc.err.text}"
        println "| Try loading dependencies from web..."
        proc = "./node_modules/.bin/bower update --quiet".execute()
        proc.waitFor()
        println "Output: ${proc.in.text}"
    }
}
