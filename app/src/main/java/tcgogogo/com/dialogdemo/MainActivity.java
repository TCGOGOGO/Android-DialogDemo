package tcgogogo.com.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button mShowButton;
    private Button mHideButton;
    private Dialog mDialog;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mDialog = new Dialog(mContext, R.style.DialogStyle);
        mDialog.setContentView(R.layout.dialog);
        mDialog.setCanceledOnTouchOutside(false);

        Window window = mDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);

        mDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Toast.makeText(mContext, "toast", Toast.LENGTH_LONG).show();
            }
        });

        mShowButton = (Button) findViewById(R.id.show_button);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.show();
            }
        });

        mHideButton = (Button) mDialog.findViewById(R.id.hide_button);
        mHideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.hide();
            }
        });
    }
}
