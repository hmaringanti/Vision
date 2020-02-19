package com.example.bribe;
            import android.app.Activity;
            import android.os.Bundle;
            import android.view.View;
            import android.widget.AdapterView;
            import android.widget.ArrayAdapter;
            import android.widget.Button;
            import android.widget.EditText;
            import android.widget.Spinner;
            import android.widget.TextView;
            import android.widget.Toast;

            import androidx.appcompat.app.AppCompatActivity;

            import com.google.firebase.database.DatabaseReference;
            import com.google.firebase.database.FirebaseDatabase;

public class complaint extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText box1, box2, box3, box4;
    Button button9;
    DatabaseReference reff;
    Member member;

    String[] Districts = {"Anantapur", "Chittoor", "East Godavari", "Guntur", "Kadapa", "Krishna", "Kurnool", "Nellore", "Prakasam", "Srikakulam", "Visakhapatnam", "Vizianagaram", "West Godavari"};

    String[] Departments = {"Bank", "Construction", "Food Quality", "Government offices", "Income Tax", "Industries&Safety measures", "Judicial", "Medical&Hospitals", "Police", "Ration", "Safety Measures"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);


        Spinner spin = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Districts);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(this);


        Spinner spin2 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<String> bb = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Departments);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(bb);
        spin2.setOnItemSelectedListener(this);

        box1 = (EditText) findViewById(R.id.editText2);
        box2 = (EditText) findViewById(R.id.editText4);
        box3 = (EditText) findViewById(R.id.editText10);
        box4 = (EditText) findViewById(R.id.editText8);
        button9 = (Button) findViewById(R.id.button9);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long aad = Long.parseLong(box3.getText().toString().trim());
                Float comp = Float.parseFloat(box4.getText().toString().trim());
                member.setName(box1.getText().toString().trim());
                member.setComplaint(box2.getText().toString().trim());
                member.setAadhar(aad);
                member.setMobile(comp);
                reff.push().setValue(member);
                Toast.makeText(complaint.this, "Your data is submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        Spinner spin = (Spinner) parent;
        Spinner spin2 = (Spinner) parent;
        if (spin.getId() == R.id.spinner3) {
            Toast.makeText(this, "Your choose :" + Districts[position], Toast.LENGTH_SHORT).show();
        }
        if (spin2.getId() == R.id.spinner4) {
            Toast.makeText(this, "Your choose :" + Departments[position], Toast.LENGTH_SHORT).show();
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Choose Countries :", Toast.LENGTH_SHORT).show();
    }
}

