import br.com.atlantico.ConfiguracaoTO
import grails.converters.JSON
class StatusController {

    private static final int BOUT_RATE = 9600;

    def controlePortaService

    ConfiguracaoTO configuracaoTO = new ConfiguracaoTO();

    def sendUrlAndPort() {
        configuracaoTO.boutRate = BOUT_RATE;
        configuracaoTO.url = params.textinputUrl;
        configuracaoTO.porta = params.textinputSerial;
        configuracaoTO.portaAberta = true;
        controlePortaService.setConfiguracaoTO(configuracaoTO)
        render([body: [status: "sucesso"]] as JSON)
    }

    def sendCancelPort() {
        configuracaoTO.url = null
        configuracaoTO.portaAberta = false;
        controlePortaService.setConfiguracaoTO(configuracaoTO)
    }

}
