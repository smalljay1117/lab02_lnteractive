package com.example.android.lab02_lnteractive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mQuantity = 0;
    private int mPrice = 50;
    private String mName = "鳴人";
    private StringBuilder mPriceMessage = new StringBuilder("臭豆腐" + "NT$" + mPrice);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPriceMessage();
    }

    private void displayPriceMessage() {
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(mPriceMessage);
    }

    public void submitOrder(View view) {
        clearPriceMessageString();
        concatPriceMessageString();
        displayPriceMessage();
    }

    private void concatPriceMessageString() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.toppings_checkbox);
        mPriceMessage.append("Name: ")
                .append(mName)
                .append("\n")
                .append("臭豆腐")
                .append("\n")
                .append("加泡菜 ? ")
                .append(checkBox.isChecked())
                .append("\n");
        if(mQuantity == 0) {
            mPriceMessage.append("Free");
        }else {
            mPriceMessage.append("Quantity: ")
                    .append(mQuantity)
                    .append("\n")
                    .append("Total: ")
                    .append("NT$")
                    .append(mPrice * mQuantity)
                    .append("\n")
                    .append("Thank you!")
                    .append("\n");
        }
    }

    private void clearPriceMessageString() {
        int start = 0;
        int end = mPriceMessage.length();
        mPriceMessage.delete(start,end);
    }

    private void displayQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(mQuantity));
    }

    public void increment(View view) {
        ++mQuantity;
        displayQuantity();
        resetPriceMessageString();
        displayPriceMessage();
    }

    public void decrement(View view) {
        if(mQuantity > 0) {
            --mQuantity;
            displayQuantity();
            resetPriceMessageString();
            displayPriceMessage();
        }
    }

    public void resetPriceMessageString() {
        clearPriceMessageString();
        mPriceMessage.append("臭豆腐")
                .append("NT$").append(mPrice);
    }

    public void clickToppings(View view) {
        resetPriceMessageString();
        displayPriceMessage();
    }
}
