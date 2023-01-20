package chain_of_responsibility;

interface Payment {
    void setNext(Payment payment);
    void pay();
    void nextPay();
}
