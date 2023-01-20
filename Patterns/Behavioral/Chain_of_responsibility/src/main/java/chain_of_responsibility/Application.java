package chain_of_responsibility;

public class Application {
    public static void main(String[] args) {
        VisaPayment visaPayment = new VisaPayment();
        PayPalPayment payPalPayment = new PayPalPayment();

        visaPayment.nextPay();
        visaPayment.setNext(payPalPayment);
        visaPayment.nextPay();
        visaPayment.pay();
    }
}
