import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class UmbrellaTest {

    @Test
    fun totalPrice_sunnyDay(){
        val umbrella = Umbrella()

        val weather = mockk<IWeather>()
        every { weather.isSunny() } returns true

        val actual = umbrella.totalPrice(weather, 3,100)
        val expected = 270
        Assert.assertEquals(expected, actual)
    }
}