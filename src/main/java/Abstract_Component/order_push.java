package Abstract_Component;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class order_push {
    public static void main(String[] args) {
        String url = "https://omsapiqa.moglilabs.com/oms/order/push";

        // Define the request body as a JSON string
        String requestBody = "{\n" +
                "  \"orderDetail\": {\n" +
                "    \"orderId\": 96439070,\n" +
                "    \"orderNumber\": \"MEA-3075708\",\n" +
                "    \"customerId\": 222,\n" +
                "    \"classificationType\": 1,\n" +
                "    \"isEmi\": 1,\n" +
                "    \"isGstinvoice\": 1,\n" +
                "    \"sellingPrice\": 250,\n" +
                "    \"orderValue\": 50000,\n" +
                "    \"orderTotal\": 50000,\n" +
                "    \"orderDiscount\": 10,\n" +
                "    \"orderEmiDiscount\": 0,\n" +
                "    \"shippingCharge\": 0,\n" +
                "    \"paymentMode\": \"ccavenue\",\n" +
                "    \"paymentStatus\": \"failed\",\n" +
                "    \"orderPlatform\": \"web\",\n" +
                "    \"orderCountry\": \"UAE\",\n" +
                "    \"promoCode\": [\n" +
                "      \"v2751\"\n" +
                "    ],\n" +
                "    \"orderDate\": \"2022-11-08 12:21:33\"\n" +
                "  },\n" +
                "  \"customerShippingAddress\": {\n" +
                "    \"firstname\": \"Shiv\",\n" +
                "    \"lastname\": \"Kumar\",\n" +
                "    \"address\": \"Khalifa Industrial Zone (Kizad)\",\n" +
                "    \"addressAlt\": \"moglix noida\",\n" +
                "    \"pincode\": \"201301\",\n" +
                "    \"city\": \"Abu Dhabi\",\n" +
                "    \"state\": \"Abu Dhabi\",\n" +
                "    \"country\": \"UAE\",\n" +
                "    \"phoneCode\": \"+971\",\n" +
                "    \"phone\": \"6291209\",\n" +
                "    \"altphone\": \"9999999999\",\n" +
                "    \"emailId\": \"atul.tyagi@moglix.com\",\n" +
                "    \"trnNo\": \"000000000000001_tln1234534\",\n" +
                "    \"customerGstin\": \"000000000000000\",\n" +
                "    \"panNo\": \"\"\n" +
                "  },\n" +
                "  \"customerBillingAddress\": {\n" +
                "    \"firstname\": \"Vaibhav\",\n" +
                "    \"lastname\": \"Kumar\",\n" +
                "    \"address\": \"Khalifa Industrial Zone (Kizad)\",\n" +
                "    \"addressAlt\": \"ahs\",\n" +
                "    \"pincode\": \"\",\n" +
                "    \"city\": \"Abu Dhabi\",\n" +
                "    \"state\": \"Abu Dhabi\",\n" +
                "    \"country\": \"UAE\",\n" +
                "    \"phoneCode\": \"+971\",\n" +
                "    \"phone\": \"9953634970\",\n" +
                "    \"altphone\": \"9999999999\",\n" +
                "    \"emailId\": \"vaibhav.kumar@moglix.com\",\n" +
                "    \"trnNo\": \"8576endnrj44332\",\n" +
                "    \"customerGstin\": \"12323abcfjrjr32\",\n" +
                "    \"panNo\": \"\"\n" +
                "  },\n" +
                "  \"orderItemDetail\": [\n" +
                "    {\n" +
                "      \"productMrp\": 250,\n" +
                "      \"purchaseTax\": 5,\n" +
                "      \"itemDiscount\": 10,\n" +
                "      \"itemPrice\": 200,\n" +
                "      \"priceWithoutTax\": 180,\n" +
                "      \"itemShipping\": 0,\n" +
                "      \"emiDiscount\": 0,\n" +
                "      \"quantity\": 1,\n" +
                "      \"productRef\": \"MSN153VYL0JYK3\",\n" +
                "      \"productHsn\": \"28382382\",\n" +
                "      \"productName\": \"Laptop\",\n" +
                "      \"productImageUrl\": \"https://cdn.moglix.com/p/R3JESJapPAhd7-small.jpg\",\n" +
                "      \"productUrl\": \"bosch-gws600-4-inch-670w-angle-grinder/mp/MSN85807W4XL92\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        // Send the POST request and save the response
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);

        // Print the response body
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());
    }
}
