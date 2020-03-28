import io.mockk.*
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test

class OrderTest {

    @Test
    fun insertOrder() {

        val order = Order()
        val mockEmailUtil = MockEmailUtil()

        val userEmail = "someMail@gmail.com"
        order.insertOrder(userEmail, 1, 200, mockEmailUtil)

        //用mockEmailUtil.receiveEmail來驗證order.insert裡是否有呼叫IEmailUtil.setCustomer
        Assert.assertEquals(userEmail, mockEmailUtil.receiveEmail)
    }

    @Test
    fun insertOrderWithMockito() {

        val order = Order()
        val mockEmailUtil = mockk<IEmailUtil>()
        val userEmail = "someMail@gmail.com"

        //驗證是否有呼叫sendCustomer，並傳入正確的userEmail
        val slot = CapturingSlot<String>()
        every { mockEmailUtil.sendCustomer(capture(slot)) }.answers {
            assertEquals(userEmail, slot.captured)
        }
        order.insertOrder(userEmail, 1, 200, mockEmailUtil)
    }
}