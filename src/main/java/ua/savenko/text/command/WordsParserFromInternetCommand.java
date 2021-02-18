package ua.savenko.text.command;

import ua.savenko.text.model.Parameter;
import ua.savenko.text.model.PearsParameter;
import ua.savenko.text.model.WordsParameter;
import ua.savenko.text.strategi.transfer.StrategyTransfer;
import ua.savenko.text.strategi.transfer.StrategyTransferWooordhunt;

public class WordsParserFromInternetCommand implements Command {

    public Parameter execute(Parameter parameter) {
        StrategyTransfer strategyTransfer = null;
        //strategyTransfer = new StrategyTransferBabla(((WordsParameter) parameter).getWords());
        strategyTransfer = new StrategyTransferWooordhunt(((WordsParameter) parameter).getWords());
        return new PearsParameter(strategyTransfer.parseInInternet());
    }
}
