package task6.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import general.validation.StringValidator;
import task6.exception.OutOfRangeOfSizeTicketList;
import task6.model.TicketsList;

public class HappyTicketsConsoleProgram extends ConsoleApp
        implements HappyTicketsConsoleProgramConsts {

    //constructor
    public HappyTicketsConsoleProgram(boolean commonFlag, String... args) {
        if (args.length == 2) {
            startHappyTicketConsoleProgram(args);
        } else run(commonFlag);
    }

    private void startHappyTicketConsoleProgram() {
        String[] interval = makeTicketValid(getTicket(INPUT_MIN), getTicket(INPUT_MAX));
        try {
            TicketsList ticketsList = new TicketsList(interval[0], interval[1]);
            printResultOfHappyCountTickets(ticketsList.countOfHappyTicketsHardMethod(),
                    ticketsList.countOfHappyTicketsOrdinaryMethod(),
                    ticketsList.countOfHappyTicketsSimpleMethod());
        } catch (OutOfRangeOfSizeTicketList e) {
            showWarning(e.getMessage());
            showInstruction(HappyTicketsConsoleProgramConsts.INSTRUCTION);
        }
    }

    private void startHappyTicketConsoleProgram(String... args) {
        String[] interval = makeTicketValid(
                StringConverter.stringIgnoreTabsSpaces(StringConverter.stringIgnorePlus(args[0])),
                StringConverter.stringIgnoreTabsSpaces(StringConverter.stringIgnorePlus(args[1])));
        if (StringValidator.isPositiveIntegerNumber(interval[0]) &&
                StringValidator.isPositiveIntegerNumber(interval[1])) {
            try {
                TicketsList ticketsList = new TicketsList(interval[0], interval[1]);
                printResultOfHappyCountTickets(ticketsList.countOfHappyTicketsHardMethod(),
                        ticketsList.countOfHappyTicketsOrdinaryMethod(),
                        ticketsList.countOfHappyTicketsSimpleMethod());
            } catch (OutOfRangeOfSizeTicketList e) {
                showWarning(e.getMessage());
                showInstruction(HappyTicketsConsoleProgramConsts.INSTRUCTION);
            }
        }
        else showInstruction(HappyTicketsConsoleProgramConsts.INSTRUCTION);
    }

    private void printResultOfHappyCountTickets(int hardMethod, int ordinaryMethod, int simpleMethod) {
        showResult(getResultOFCompareOfHappyTicketsCount(hardMethod, ordinaryMethod, simpleMethod));
        showResult(HARD_METHOD_COUNT + hardMethod);
        showResult(ORDINARY_METHOD_COUNT + ordinaryMethod);
        showResult(SIMPLE_METHOD_COUNT + simpleMethod);
    }

    private String[] makeTicketValid(String min, String max) {
        int diff = max.length() - min.length();
        while (diff != 0) {
            if (diff < 0) {
                max = "0" + max;
            } else if (diff > 0) {
                min = "0" + min;
            }
            diff = max.length() - min.length();
        }
        return new String[]{min, max};
    }

    private String getTicket(String message) {
        String result = "";
        do {
            result = inputDataFiltered(message);
            if (StringValidator.isPositiveIntegerNumber(result)) {
                return result;
            }
            showStandartWarning();
            showInstruction(HappyTicketsConsoleProgramConsts.INSTRUCTION);
        } while (true);
    }

    @Override
    public ConsoleApp run(boolean commonFlag) {
        boolean closeFlag = false;
        do {
            showData(menu(commonFlag));
            int i = StringConverter.stringToInt(inputDataFiltered("Your choice:"));
            switch (i) {
                case 1:
                    startHappyTicketConsoleProgram();
                    continue;
                case 2:
                    closeFlag = close();
                    break;
                default:
                    showStandartWarning();
                    showInstruction(ConsoleApp.INSTRUCTION);
            }
        } while (!closeFlag);
        if (commonFlag) return new ConsoleProgram();
        else return null;
    }

    private String menu(boolean commonFlag) {
        if (commonFlag) return menu(NAME_PROGRAM, COMMON_MENU);
        return menu(NAME_PROGRAM, MENU);
    }
}
