package chain_of_responsibility;

class PayPalPayment implements Payment {
    private Payment payment;
    @Override
    public void setNext(Payment payment) {
        this.payment = payment;
    }
    @Override
    public void pay() {
        System.out.println("PayPal Payment");
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
