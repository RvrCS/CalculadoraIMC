package torres.river.asignacion4_calculadoraimc_apellido

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Variables
        val height: EditText = findViewById<EditText>(R.id.etEstatura)
        val weight: EditText = findViewById<EditText>(R.id.etPeso)
        val calculate: Button = findViewById(R.id.btnCalculate)
        val IMC: TextView = findViewById(R.id.tvIMC)
        val categoryIMC: TextView = findViewById(R.id.tvCategoria)


        calculate.setOnClickListener {

            if(height.text != null && weight.text != null) {

                var heightValue = height.text.toString().toFloat()
                var weightValue = weight.text.toString().toFloat()

                var imcValue = calculateIMC(heightValue, weightValue)

                IMC.setText("IMC de: " + String.format("%.2f", imcValue))


                if(imcValue < 18.5){
                    categoryIMC.setText("Bajo peso")
                    categoryIMC.setBackgroundResource(R.color.colorRed)
                }
                if(imcValue >= 18.5 && imcValue <24.9){
                    categoryIMC.setText("Normal")
                    categoryIMC.setBackgroundResource(R.color.colorGreenish)

                }
                if(imcValue > 24.9 && imcValue <29.9){
                    categoryIMC.setText("Sobrepeso")
                    categoryIMC.setBackgroundResource(R.color.colorYellow)

                }
                if(imcValue >= 30 && imcValue <34.9){
                    categoryIMC.setText("Obesidad grado 1")
                    categoryIMC.setBackgroundResource(R.color.colorRed)

                }
                if(imcValue >= 35 && imcValue <39.9){
                    categoryIMC.setText("Obesidad grado 2")
                    categoryIMC.setBackgroundResource(R.color.colorRed)

                }
                if(imcValue >= 40){
                    categoryIMC.setText("Obesidad grado 3")
                    categoryIMC.setBackgroundResource(R.color.colorRed)

                }

                IMC.visibility = View.VISIBLE
                categoryIMC.visibility = View.VISIBLE

            }else{
                println("Campos vacíos")
            }




        }

    }

    fun calculateIMC(heightValue: Float, weightValue: Float) = weightValue / (Math.pow(heightValue.toDouble(), 2.0))

}