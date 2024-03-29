package events;

import entities.Room;
import games.GenericGame;
import userInterface.printer.Printer;

public class DoorLockedHandler extends EventHandler{
    public DoorLockedHandler(Event event) {
        super(event);
    }

    @Override
    public void completeEvent(GenericGame game, Printer out) {
        if(game.getMainCharacter().getInventory().getList().containsAll(getEvent().getRequiredObjects())){
            out.print("\n" +getEvent().getEndPhrase() + "\n");
            game.getCurrentRoom().getNord().setLocked(false);

            //faccio partire l'evento della cameretta in cui si spengono tutte le luci
            game.getCurrentRoom().getEst().getEventHandler().startEvent(out);
            turnOfAll(game.getCurrentRoom());
            game.getCurrentRoom().getEst().setVisible(true);
            getEvent().setCompleted(true);
        }
    }

    private void turnOfAll(Room room){
        if(room != null && room.isVisible()){
            room.setVisible(false);
            turnOfAll(room.getEst());
            turnOfAll(room.getOvest());
            turnOfAll(room.getNord());
            turnOfAll(room.getSud());
        }
    }

}
