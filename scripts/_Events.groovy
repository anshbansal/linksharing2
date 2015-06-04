eventCompileStart = {kind ->
    // Ants Project is available via: kind.ant.project
    executeGruntTasks()
    // Obtain status and output
}
 
private void executeGruntTasks(){
    println "| Load js dependencies from cache..."
    def proc = "grunt".execute()  // execute default task to load dependencies from local cache.
    proc.waitFor()                              
    if(proc.exitValue()!=0){
        println "| Error occured while loading dependencies from local cache : ${proc.err.text}"
        println "| Try loading dependencies from web..."
        proc = "grunt webInstall".execute()
        proc.waitFor()                               // Wait for the command to finish
        println "Output: ${proc.in.text}"
    }
}
