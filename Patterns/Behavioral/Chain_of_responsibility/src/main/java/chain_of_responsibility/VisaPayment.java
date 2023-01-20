package chain_of_responsibility;

class VisaPayment implements Payment {
    private Payment payment;
    @Override
    public void setNext(Payment payment) {
        this.payment = payment;
    }
    @Override
    public void pay() {
        System.out.println("Visa Payment");
    }
    @Override
    public void nextPay() {
        if (payment != null) {
            payment.pay();
        } else {
            System.out.println("Выполните метод \"setNext(Payment payment)\"");
        }
    }
}
