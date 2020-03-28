class Order {
    fun insertOrder(email: String, quantity: Int, price: Int, emailUtil: IEmailUtil){

        val weather = Weather()
        val umbrella = Umbrella()
        umbrella.totalPrice(weather, quantity, price)

        //結帳...(省略)

        //寄送Email給客人
        emailUtil.sendCustomer(email)
    }
}