package com.anshbansal.filter

class ApplicationFilters {

    def filters = {
        all(controllerExclude: 'assets|console', action:'*') {
            before = {
                log.info "Request to ${controllerName}:${actionName} with parameters ${params}"
            }
        }
    }
}
