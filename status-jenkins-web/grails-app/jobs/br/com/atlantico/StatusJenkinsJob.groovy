package br.com.atlantico

import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse

import static org.apache.commons.lang.StringUtils.contains;

class StatusJenkinsJob {

    private static final String SUCCESS_BUILD_COLOR = "red";
    private static final int BUILD_FAIL = 0;
    private static final int BUILD_SUCCESS = 1;

    def controlePortaService
    RestBuilder rest = new RestBuilder()


    static triggers = {
        simple repeatInterval: 5001 // execute job once in 5 seconds
    }

    private boolean isBuildSuccessful(String jsonString) {
        if (contains(jsonString, SUCCESS_BUILD_COLOR)) {
            return true;
        }
        return false;
    }

    def execute() {
        ConfiguracaoTO configuracaoTO = controlePortaService.configuracaoTO;
        if ( configuracaoTO != null && configuracaoTO.url != null) {
            RestResponse response = rest.get(configuracaoTO.url) {
                accept JSON
            }
            boolean buildSuccess = isBuildSuccessful(response.json.color);
            if (configuracaoTO.portaAberta) {
                controlePortaService.abrirPorta();
                configuracaoTO.portaAberta = false;
            }
            controlePortaService.enviaDados(buildSuccess ? BUILD_SUCCESS : BUILD_FAIL);
        }
    }

}
