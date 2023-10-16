//For radio group and auto complete text view
        Place=findViewById(R.id.PlaceBox);
        GenGroup=findViewById(R.id.GenderGroup);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.select_dialog_item,Locations);
        Place.setThreshold(1);
        Place.setAdapter(adapter);
        GenGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,int checkedId){
                RBtn=findViewById(checkedId);
            }
        });



//For Calender
        Calendar c = Calendar.getInstance();
        int pYear = c.get(Calendar.YEAR);
        int pMonth = c.get(Calendar.MONTH);
        int pDate = c.get(Calendar.DATE);
        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                android.R.style.Theme_DeviceDefault_DialogWhenLarge, new
                DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                        diff = pYear - year;
                    }
                },pYear, pMonth, pDate);
        dialog.show();


//For Intent Give
public void checkEligibility(View v) {
        String s_name = name.getText().toString();
        String s_num = num.getText().toString();
        Intent in = new Intent(getApplicationContext(), MainActivity2.class);
        in.putExtra("NAME",s_name);
        in.putExtra("ADHAR",s_num);
        in.putExtra("AGE",diff);
        startActivity(in);
    }


//For Intent Receive
        Intent intt = getIntent();
        String r_name = intt.getStringExtra("NAME");
        String r_aadhar = intt.getStringExtra("AADHAR");
        int age = intt.getIntExtra("AGE",0);
        if(age>=18)
            res.setText("Name: "+r_name+"\nAadhar Number: "+r_aadhar+"\n You are eligible to vote");
        else
            res.setText("Name: "+r_name+"\nAadhar Number: "+r_aadhar+"\n You are not eligible to vote");


//For Spinner
        elec = findViewById(R.id.electivesBox);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.courses));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        elec.setAdapter(adapter);
        elec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCourse = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
