package cnon.software.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText number1Text;
    EditText number2Text;
    TextView resultText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        number1Text=findViewById(R.id.number1Text);
        number2Text=findViewById(R.id.number2Text);
        resultText = findViewById(R.id.resultText);
    }


    private  void  process(char type)
    {
        try {
            int number1 = Integer.parseInt(number1Text.getText().toString());
            int number2 = Integer.parseInt(number2Text.getText().toString());
            int result;
            switch (type)
            {
                case '+':
                    result = number1 + number2;
                    break;

                case '*':
                    result = number1 * number2;
                    break;

                case '-':
                    result = number1 - number2;
                    break;

                case '/':
                    result = number1 / number2;
                    break;
                default:
                    result=0;
            }

            resultText.setText("Result: "+result);
        }
        catch (Exception e)
        {
            resultText.setText("Result: "+e);
        }
    }



    public void sum(View view)
    {
        process('+');

    }

    public void subtract(View view)
    {
        process('-');
    }


    public void multiply(View view)
    {
        process('*');
    }


    public void divide(View view)
    {

        process('/');
    }


}