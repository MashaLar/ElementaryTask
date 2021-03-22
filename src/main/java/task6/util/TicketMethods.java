package task6.util;

import task6.model.Ticket;

public enum TicketMethods implements HappyMethods{

    HARD_METHOD(){
        @Override
        public boolean isHappy(Ticket ticket){
            return HardMethod.INSTANCE.isHappy(ticket);
        }
    },

    ORDINARY_METHOD(){
        @Override
        public boolean isHappy(Ticket ticket){
            return OrdinaryMethod.INSTANCE.isHappy(ticket);
        }
    },

    SIMPLE_METHOD(){
        @Override
        public boolean isHappy(Ticket ticket){
            return SimpleMethod.INSTANCE.isHappy(ticket);
        }
    };

    public abstract boolean isHappy(Ticket ticket);

}
