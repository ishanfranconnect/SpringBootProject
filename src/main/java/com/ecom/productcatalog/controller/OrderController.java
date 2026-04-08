@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }]
    @PostMapping
    public String placeOrder(){
        orderService.placeOrder();
        return "Order placed successfully";
    }
}
