eventCompileStart = {kind ->
    // Ants Project is available via: kind.ant.project
    updateJavascriptDependencies()
    // Obtain status and output
}
 
private void updateJavascriptDependencies(){
    println "| Load js dependencies from cache..."
    def proc = "./node_modules/.bin/bower update --quiet".execute()
    proc.waitFor()                              
    println "Output: ${proc.in.text}"
}
