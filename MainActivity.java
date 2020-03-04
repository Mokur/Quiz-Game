public class MainActivity extends AppCompatActivity {

    Button btnBasla,btnNasilOynanir,btnHakkinda,btnKesfet;
    ToggleButton tgSes;
    ImageView ivSeviye;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        final MediaPlayer btnTıklama = MediaPlayer.create(this, R.raw.buttonclick);



        btnBasla = findViewById(R.id.btnBasla);
        btnNasilOynanir = findViewById(R.id.btnNasilOynanir);
        tgSes = findViewById(R.id.tgSes);
        btnHakkinda = findViewById(R.id.btnHakkinda);
        ivSeviye = findViewById(R.id.ivSeviye);
        btnKesfet = findViewById(R.id.btnKesfet);


        btnBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tgSes.isChecked()){
                    btnTıklama.start();
                }

                Intent intent = new Intent(getApplicationContext(),OyunActivity.class);
                startActivity(intent);
            }
        });

        btnNasilOynanir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tgSes.isChecked()){
                    btnTıklama.start();
                }                Intent intent = new Intent(getApplicationContext(),TutorialActivity.class);
                startActivity(intent);
            }
        });

        tgSes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (tgSes.isChecked()){
                    btnTıklama.start();
                }
            }
        });

        btnHakkinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tgSes.isChecked()){
                    btnTıklama.start();
                }            }
        });


        btnKesfet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tgSes.isChecked()){
                    btnTıklama.start();
                }          }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        adb.setTitle("Çıkış Yapılsın mı?");//Başlık
        adb.setCancelable(true);//vazgeçilebilsin mi?
        adb.setMessage("Uygulamadan çıkmak istediğinize emin misiniz?");
        adb.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

               finish();//activity'i kapatır ve uygulamadan çıkılır


            }
        });
        adb.setNegativeButton("Vazgeç", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        adb.create();
        adb.show();
    }
}
