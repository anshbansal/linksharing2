package com.anshbansal.controller.util

import groovy.json.JsonBuilder

class GenerationController {

    def linkJson() {

        def json = new JsonBuilder()

        json {
            ajaxLinks {
                auth {
                    login g.createLink(controller: 'auth', action: 'loginAuth')
                }
            }
        }

        new File('grails-app/assets/javascripts/serverConfig.js')
                .write("var serverConfig = ${json.toPrettyString()};")

    }
}
