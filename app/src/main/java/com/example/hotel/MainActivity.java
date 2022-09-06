package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    dbhotel db = new dbhotel(this);
    public String xname="Alex";
    public  String xprice="70$/n";
    public  String xplace="DUBI";
    public String xstars="4 stars";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<item> listofhotels =new ArrayList<item>();
        listofhotels.add(new item("Helton", "DUBI","5 stars","50$/n",R.drawable.hotel6));
        listofhotels.add(new item("Alex", "DUBI","3 stars","60$/n",R.drawable.hotel2));
        listofhotels.add(new item("Sheraton", "ABU ZABI","4 stars","100$/n",R.drawable.hotel3));
        listofhotels.add(new item("Mount", "DUBI","4 stars","60$/n",R.drawable.hotel4));
        listofhotels.add(new item("Sheraton", "ABU ZABI","4 stars","65$/n",R.drawable.hotel3));
        listofhotels.add(new item("Mount", "DUBI","4 stars","70$/n",R.drawable.hotel4));


        /*
        db.insertdata(listofhotels.get(0).name,listofhotels.get(0).place,listofhotels.get(0).stars,listofhotels.get(0).price,listofhotels.get(0).image);
        db.insertdata(listofhotels.get(1).name,listofhotels.get(1).place,listofhotels.get(1).stars,listofhotels.get(1).price,listofhotels.get(1).image);
        db.insertdata(listofhotels.get(2).name,listofhotels.get(2).place,listofhotels.get(2).stars,listofhotels.get(2).price,listofhotels.get(2).image);
        db.insertdata(listofhotels.get(3).name,listofhotels.get(3).place,listofhotels.get(3).stars,listofhotels.get(3).price,listofhotels.get(3).image);
        db.insertdata(listofhotels.get(4).name,listofhotels.get(4).place,listofhotels.get(4).stars,listofhotels.get(4).price,listofhotels.get(4).image);
        db.insertdata(listofhotels.get(5).name,listofhotels.get(5).place,listofhotels.get(5).stars,listofhotels.get(5).price,listofhotels.get(5).image);
        */

        // ArrayList dis =new ArrayList<>();

        //adapter myadapter =new adapter(listofhotels);
        //ListView hotel_list =(ListView)findViewById(R.id.hotel_list);
        //hotel_list.setAdapter(myadapter);
        //adapter arrayadapter =new adapter(dis);

        adapter adp =new adapter(db.getdata(xname,xprice,xplace,xstars));
        ListView hotel_list =(ListView)findViewById(R.id.hotel_list);
        hotel_list.setAdapter(adp);

    }


    class adapter extends BaseAdapter
    {
        ArrayList<item> items =new ArrayList<item>();

        public adapter(ArrayList<item> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater linflater =  getLayoutInflater();
            // used to connect the view
            View view1=linflater.inflate(R.layout.row,null);
            TextView name =(TextView) view1.findViewById(R.id.name);
            TextView place =(TextView) view1.findViewById(R.id.place);
            TextView stars =(TextView) view1.findViewById(R.id.stars);
            TextView price =(TextView) view1.findViewById(R.id.price);
            ImageView image =(ImageView) view1.findViewById(R.id.image);

            name.setText(items.get(position).name);
            place.setText(items.get(position).place);
            stars.setText(items.get(position).stars);
            price.setText(items.get(position).price);
            image.setImageResource(items.get(position).image);

            return view1;
        }
    }
}