package example.welcome.com.candycrush;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<ImageView> imageViews = new ArrayList<>();
    ArrayList<Integer> number = new ArrayList<>();
    int imageClick;
    //is for swaping or 1st image
    ImageView myImageView;
    int globalNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button4);
        btn.setBackgroundColor(Color.MAGENTA);

        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);
        number.add(6);

        for (int i=1; i<82;i++){

            String str = "r"+i;
            int id = getResources().getIdentifier(str, "id", getPackageName());
            imageViews.add((ImageView)findViewById(id));
        }

        for (ImageView img: imageViews){

            img.setOnClickListener(imageListner);
        }

        refresh();
    }

    public void onClickImage(ImageView imageView){

        imageClick++;
        Object Tag = imageView.getTag();
        if (imageClick == 1){

            myImageView = imageView;
            if (Tag.equals(1)){
                imageView.setImageResource(R.drawable.blueone);
                myImageView.setTag(1);
            }else if (Tag.equals(2)){
                imageView.setImageResource(R.drawable.greenone);
                myImageView.setTag(2);
            }else if (Tag.equals(3)){
                imageView.setImageResource(R.drawable.orangeone);
                myImageView.setTag(3);
            }else if (Tag.equals(4)){
                imageView.setImageResource(R.drawable.purpleone);
                myImageView.setTag(4);
            }else if (Tag.equals(5)){
                imageView.setImageResource(R.drawable.redone);
                myImageView.setTag(5);
            }else if (Tag.equals(6)){
                imageView.setImageResource(R.drawable.yellowone);
                myImageView.setTag(6);
            }
        }

        if (imageClick == 2){

            int index1 = imageViews.indexOf(myImageView);
            int index2 = imageViews.indexOf(imageView);
            //Toast.makeText(this, "Index 1 : "+index1, Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "Index 2 : "+index2, Toast.LENGTH_SHORT).show();

            if (index2 == index1){

                imageClick = 0;
                if (Tag.equals(1)){
                    myImageView.setImageResource(R.drawable.blue);
                    myImageView.setTag(1);
                }else if (Tag.equals(2)){
                    myImageView.setImageResource(R.drawable.green);
                    myImageView.setTag(2);
                }else if (Tag.equals(3)){
                    myImageView.setImageResource(R.drawable.orange);
                    myImageView.setTag(3);
                }else if (Tag.equals(4)){
                    myImageView.setImageResource(R.drawable.purple);
                    myImageView.setTag(4);
                }else if (Tag.equals(5)){
                    myImageView.setImageResource(R.drawable.red);
                    myImageView.setTag(5);
                }else if (Tag.equals(6)){
                    myImageView.setImageResource(R.drawable.yellow);
                    myImageView.setTag(6);
                }
            }else if ((index1-9) == index2 || (index1+9) == index2 || (index1-1) == index2 || (index1+1) == index2){

                Object tag1 = myImageView.getTag();

                if (tag1.equals(1)){
                    imageView.setImageResource(R.drawable.blue);
                    imageView.setTag(1);
                }else if (tag1.equals(2)){
                    imageView.setImageResource(R.drawable.green);
                    imageView.setTag(2);
                }else if (tag1.equals(3)){
                    imageView.setImageResource(R.drawable.orange);
                    imageView.setTag(3);
                }else if (tag1.equals(4)){
                    imageView.setImageResource(R.drawable.purple);
                    imageView.setTag(4);
                }else if (tag1.equals(5)){
                    imageView.setImageResource(R.drawable.red);
                    imageView.setTag(5);
                }else if (tag1.equals(6)){
                    imageView.setImageResource(R.drawable.yellow);
                    imageView.setTag(6);
                }

                if (Tag.equals(1)){
                    myImageView.setImageResource(R.drawable.blue);
                    myImageView.setTag(1);
                }else if (Tag.equals(2)){
                    myImageView.setImageResource(R.drawable.green);
                    myImageView.setTag(2);
                }else if (Tag.equals(3)){
                    myImageView.setImageResource(R.drawable.orange);
                    myImageView.setTag(3);
                }else if (Tag.equals(4)){
                    myImageView.setImageResource(R.drawable.purple);
                    myImageView.setTag(4);
                }else if (Tag.equals(5)){
                    myImageView.setImageResource(R.drawable.red);
                    myImageView.setTag(5);
                }else if (Tag.equals(6)){
                    myImageView.setImageResource(R.drawable.yellow);
                    myImageView.setTag(6);
                }
                imageClick = 0;
                checkSequence(imageView, myImageView);
                checkIt();
            }else {
                imageClick = 0;
            }
        }
    }

    private View.OnClickListener imageListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            for (int i=0;i<imageViews.size();i++){

                if (v == imageViews.get(i)){

                    ImageView imageView = imageViews.get(i);
                    onClickImage(imageView);
                }
            }
        }
    };

    public void checkSequence(ImageView imageView1, ImageView imageView2){

        globalNum = 0;
        //taking index
        int index1 = imageViews.indexOf(imageView1);
        int index2 = imageViews.indexOf(imageView2);

        try{

            ImageView oneImage = null;
            ImageView twoImage = null;
            ImageView threeImage = null;
            ImageView fourImage = null;

            if (index1 == 80){
                threeImage = imageViews.get(index1-1);
                fourImage = imageViews.get(index1-2);
            }else if (index1 == 79){
                oneImage = imageViews.get(index1+1);
                threeImage = imageViews.get(index1-1);
                fourImage = imageViews.get(index1-2);
            }else if (index1 == 0){
                oneImage = imageViews.get(index1+1);
                twoImage = imageViews.get(index1+2);
            }else if (index1 == 1){
                oneImage = imageViews.get(index1+1);
                twoImage = imageViews.get(index1+2);
                threeImage = imageViews.get(index1-1);
            }else {
                oneImage = imageViews.get(index1+1);
                twoImage = imageViews.get(index1+2);
                threeImage = imageViews.get(index1-1);
                fourImage = imageViews.get(index1-2);
            }

            if ((index1 >= 0 && index1 < 7) || (index1 >= 9 && index1 <16) || (index1 >=18 && index1 <25) || (index1 >= 27 && index1 <34)
                    || (index1 >= 36 && index1 <43) || (index1 >= 45 && index1 <52) || (index1 >= 54 && index1 < 61) ||
                    (index1 >= 63 && index1 < 70) || (index1 >= 72 && index1 < 79)){
                //TODO: to check only forward 2 numbers
                if (imageView1.getTag().equals(oneImage.getTag()) && imageView1.getTag().equals(twoImage.getTag())){
                    //changeImage(imageView1, oneImage, twoImage, imageView1.getTag());
                    exchangeImageOfHorizontal(imageView1, oneImage, twoImage);
                    globalNum++;
                }

            }
            if ((index1 > 0 && index1 <= 7) || (index1 > 9 && index1 <=16) || (index1 >18 && index1 <=25) || (index1 > 27 && index1 <=34)
                    || (index1 > 36 && index1 <=43) || (index1 > 45 && index1 <=52) || (index1 > 54 && index1 <=61) ||
                    (index1 > 63 && index1 <= 70) || (index1 > 72 && index1 <= 79)){
                if (imageView1.getTag().equals(oneImage.getTag()) && imageView1.getTag().equals(threeImage.getTag())){

                    //changeImage(oneImage, imageView1,threeImage, imageView1.getTag());
                    exchangeImageOfHorizontal(oneImage, imageView1, threeImage);
                    globalNum++;
                }
                //TODO: to check with middle index
            }
            if ((index1 > 1 && index1 <= 8) || (index1 > 10 && index1 <=17) || (index1 >19 && index1 <=26) || (index1 > 28 && index1 <=35)
                    || (index1 > 37 && index1 <=44) || (index1 > 46 && index1 <=53) || (index1 > 55 && index1 <= 62) ||
                    (index1 > 64 && index1 <= 71) || (index1 > 73 && index1 <=80)){

                //TODO: to check only backward
                if (imageView1.getTag().equals(threeImage.getTag()) && imageView1.getTag().equals(fourImage.getTag())){

                    //changeImage(fourImage, threeImage, imageView1, imageView1.getTag());
                    exchangeImageOfHorizontal(fourImage, threeImage, imageView1);
                    globalNum++;
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "Hmmm that's not fair", Toast.LENGTH_SHORT).show();
        }
        globalNum = 0;

        //=====cheking for imageView2 ==========================================================//

        try{

            ImageView oneImage = null;
            ImageView twoImage = null;
            ImageView threeImage = null;
            ImageView fourImage = null;

            if (index2 == 80){
                threeImage = imageViews.get(index2-1);
                fourImage = imageViews.get(index2-2);
            }else if (index2 == 79){
                oneImage = imageViews.get(index2+1);
                threeImage = imageViews.get(index2-1);
                fourImage = imageViews.get(index2-2);
            }else if (index2 == 0){
                oneImage = imageViews.get(index2+1);
                twoImage = imageViews.get(index2+2);
            }else if (index2 == 1){
                oneImage = imageViews.get(index2+1);
                twoImage = imageViews.get(index2+2);
                threeImage = imageViews.get(index2-1);
            }else {
                oneImage = imageViews.get(index2+1);
                twoImage = imageViews.get(index2+2);
                threeImage = imageViews.get(index2-1);
                fourImage = imageViews.get(index2-2);
            }

            if ((index2 >= 0 && index2 < 7) || (index2 >= 9 && index2 <16) || (index2 >=18 && index2 <25) || (index2 >= 27 && index2 <34)
                    || (index2 >= 36 && index2 <43) || (index2 >= 45 && index2 <52) || (index2 >= 54 && index2 < 61) ||
                    (index2 >= 63 && index2 < 70) || (index2 >= 72 && index2 < 79)){
                //TODO: to check only forward 2 numbers
                if (imageView2.getTag().equals(oneImage.getTag()) && imageView2.getTag().equals(twoImage.getTag())){
                    //changeImage(imageView2, oneImage, twoImage, imageView2.getTag());
                    exchangeImageOfHorizontal(imageView2, oneImage, twoImage);
                    globalNum++;
                }

            }
            if ((index2 > 0 && index2 <= 7) || (index2 > 9 && index2 <=16) || (index2 >18 && index2 <=25) || (index2 > 27 && index2 <=34)
                    || (index2 > 36 && index2 <=43) || (index2 > 45 && index2 <=52) || (index2 > 54 && index2 <=61) ||
                    (index2 > 63 && index2 <= 70) || (index2 > 72 && index2 <= 79)){
                if (imageView2.getTag().equals(oneImage.getTag()) && imageView2.getTag().equals(threeImage.getTag())){

                    //changeImage(oneImage, imageView2,threeImage, imageView2.getTag());
                    exchangeImageOfHorizontal(oneImage, imageView2, threeImage);
                    globalNum++;
                }
                //TODO: to check with middle index
            }
            if ((index2 > 1 && index2 <= 8) || (index2 > 10 && index2 <=17) || (index2 >19 && index2 <=26) || (index2 > 28 && index2 <=35)
                    || (index2 > 37 && index2 <=44) || (index2 > 46 && index2 <=53) || (index2 > 55 && index2 <= 62) ||
                    (index2 > 64 && index2 <= 71) || (index2 > 73 && index2 <=80)){

                //TODO: to check only backward
                if (imageView2.getTag().equals(threeImage.getTag()) && imageView2.getTag().equals(fourImage.getTag())){

                    //changeImage(fourImage, threeImage, imageView2, imageView2.getTag());
                    exchangeImageOfHorizontal(fourImage, threeImage, imageView2);
                    globalNum++;
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "Hmmm that's not fair", Toast.LENGTH_SHORT).show();
        }
        globalNum = 0;


        //=====================Checking for Vertical ========================================//

        try{

            ImageView oneImage = null;
            ImageView twoImage = null;
            ImageView threeImage = null;
            ImageView fourImage = null;

            //TODO Vertical checking
            if(index1 >= 0 && index1 <=62){
                oneImage = imageViews.get(index1+9);
                twoImage = imageViews.get(index1+18);
                if (imageView1.getTag().equals(oneImage.getTag()) && imageView1.getTag().equals(twoImage.getTag())){
                    //changeImage(imageView1, oneImage, twoImage, imageView1.getTag());
                    exchangeImageOfVertical(imageView1, oneImage, twoImage);
                }
            }
            if (index1 >=9 && index1 <=71){
                oneImage = imageViews.get(index1-9);
                twoImage = imageViews.get(index1+9);
                if (imageView1.getTag().equals(oneImage.getTag()) && imageView1.getTag().equals(twoImage.getTag())){
                    //changeImage(oneImage, imageView1, twoImage, imageView1.getTag());
                    exchangeImageOfVertical(oneImage, imageView1, twoImage);
                }
            }
            if (index1 >=18 && index1 <= 80){

                oneImage = imageViews.get(index1-18);
                twoImage = imageViews.get(index1-9);
                if (imageView1.getTag().equals(oneImage.getTag()) && imageView1.getTag().equals(twoImage.getTag())){
                    //changeImage(oneImage, twoImage, imageView1, imageView1.getTag());
                    exchangeImageOfVertical(oneImage, twoImage, imageView1);
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "Hmmm that's not fair", Toast.LENGTH_SHORT).show();
        }

        //=============================checking for imageView2 ===================================//

        try{

            ImageView oneImage = null;
            ImageView twoImage = null;
            ImageView threeImage = null;
            ImageView fourImage = null;

            //TODO Vertical checking
            if(index2 >= 0 && index2 <=62){
                oneImage = imageViews.get(index2+9);
                twoImage = imageViews.get(index2+18);
                if (imageView2.getTag().equals(oneImage.getTag()) && imageView2.getTag().equals(twoImage.getTag())){
                    //changeImage(imageView2, oneImage, twoImage, imageView2.getTag());
                    exchangeImageOfVertical(imageView2, oneImage, twoImage);
                }
            }
            if (index2 >=9 && index2 <=71){
                oneImage = imageViews.get(index2-9);
                twoImage = imageViews.get(index2+9);
                if (imageView2.getTag().equals(oneImage.getTag()) && imageView2.getTag().equals(twoImage.getTag())){
                    //changeImage(oneImage, imageView2, twoImage, imageView2.getTag());
                    exchangeImageOfVertical(oneImage, imageView2, twoImage);
                }
            }
            if (index2 >=18 && index2 <= 80){

                oneImage = imageViews.get(index2-18);
                twoImage = imageViews.get(index2-9);
                if (imageView2.getTag().equals(oneImage.getTag()) && imageView2.getTag().equals(twoImage.getTag())){
                    //changeImage(oneImage, twoImage, imageView2, imageView2.getTag());
                    exchangeImageOfVertical(oneImage, twoImage, imageView2);
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "Hmmm that's not fair", Toast.LENGTH_SHORT).show();
        }
        globalNum = 0;
    }

    public void changeImage(ImageView imageView1, ImageView imageView2, ImageView imageView, Object tag){

        if (tag.equals(1)){
            imageView.setImageResource(R.drawable.bluetwo);
            imageView1.setImageResource(R.drawable.bluetwo);
            imageView2.setImageResource(R.drawable.bluetwo);
        }else if (tag.equals(2)){
            imageView.setImageResource(R.drawable.greentwo);
            imageView1.setImageResource(R.drawable.greentwo);
            imageView2.setImageResource(R.drawable.greentwo);
        }else if (tag.equals(3)){
            imageView.setImageResource(R.drawable.orangetwo);
            imageView1.setImageResource(R.drawable.orangetwo);
            imageView2.setImageResource(R.drawable.orangetwo);
        }else if (tag.equals(4)){
            imageView.setImageResource(R.drawable.purpletwo);
            imageView1.setImageResource(R.drawable.purpletwo);
            imageView2.setImageResource(R.drawable.purpletwo);
        }else if (tag.equals(5)){
            imageView.setImageResource(R.drawable.redtwo);
            imageView1.setImageResource(R.drawable.redtwo);
            imageView2.setImageResource(R.drawable.redtwo);
        }else if (tag.equals(6)){
            imageView.setImageResource(R.drawable.yellowtwo);
            imageView1.setImageResource(R.drawable.yellowtwo);
            imageView2.setImageResource(R.drawable.yellowtwo);
        }
    }

    public void exchangeImageOfHorizontal(ImageView imageView1, ImageView imageView2, ImageView imageView3){

        int index1 = imageViews.indexOf(imageView1);
        int index2 = imageViews.indexOf(imageView2);
        int index3 = imageViews.indexOf(imageView3);
        int loop = 0;

        if (index1 >= 72 && index1 <= 80){
            loop = 9;
        }else if (index1 >= 63 && index1 <= 71){
            loop = 8;
        }else if (index1 >= 54 && index1 <= 62){
            loop = 7;
        }else if (index1 >= 45 && index1 <= 53){
            loop = 6;
        }else if (index1 >= 36 && index1 <= 44){
            loop = 5;
        }else if (index1 >= 27 && index1 <= 35){
            loop = 4;
        }else if (index1 >= 18 && index1 <= 26){
            loop = 3;
        }else if (index1 >= 9 && index1 <= 17){
            loop = 2;
        }else if (index1 >= 0 && index1 <= 8){
            loop = 1;
        }

        if (loop == 1){

            for (int j=1; j<=3; j++){
                Collections.shuffle(number);
                if (j==1){
                    cc(imageViews.get(index1));
                }else if (j==2){
                    cc(imageViews.get(index2));
                }else {
                    cc(imageViews.get(index3));
                }
            }

        }else {
            for (int i=loop; i >= 1; i--){

                if (i == 1){

                    for (int j=1; j<=3; j++) {
                        Collections.shuffle(number);
                        if (j == 1) {
                            cc(imageViews.get(index1));
                        } else if (j == 2) {
                            cc(imageViews.get(index2));
                        } else {
                            cc(imageViews.get(index3));
                        }
                    }
                }else {

                    for (int j=1; j<=3;j++){

                        if (j==1){
                            changeColor(imageViews.get(index1), imageViews.get(index1-9));
                        }else if ( j==2 ){
                            changeColor(imageViews.get(index2), imageViews.get(index2-9));
                        }else {
                            changeColor(imageViews.get(index3), imageViews.get(index3-9));
                        }
                    }
                }

                index1 = index1 - 9;
                index2 = index2 - 9;
                index3 = index3 - 9;
            }
        }
    }

    public void exchangeImageOfVertical(ImageView imageView1, ImageView imageView2, ImageView imageView3){

        int index1 = imageViews.indexOf(imageView1);
        int index2 = imageViews.indexOf(imageView2);
        int index3 = imageViews.indexOf(imageView3);

        //lower row
        if (index1 >=54 && index1 <= 62){
            int i=0;
            while (i<=2){

                if (i==2){

                    for (int j=1;j<=3;j++){

                        if (j==1){
                            cc(imageViews.get(index3));
                        }else if (j==2){
                            cc(imageViews.get(index2));
                        }else {
                            cc(imageViews.get(index1));
                        }
                    }
                }else {
                    for (int j=1; j<=3; j++){

                        if (j==1){
                            changeColor(imageViews.get(index1), imageViews.get(index1-27));
                        }else if (j==2){
                            changeColor(imageViews.get(index2), imageViews.get(index2-27));
                        }else {
                            changeColor(imageViews.get(index3), imageViews.get(index3 - 27));
                        }
                    }
                }

                index1 = index1 - 27;
                index2 = index2 - 27;
                index3 = index3 - 27;
                i++;
            }
        } else if (index1 >= 45 && index1 <= 53){

            int i=0;
            while (i<=2){

                if (i==2){

                    for (int j=1;j<=2;j++){

                        if (j==1){
                            cc(imageViews.get(index3));
                        } else{
                            cc(imageViews.get(index2));
                        }
                    }
                }else {
                    for (int j=1; j<=3; j++){

                        if (j==1){
                            if (i==1){
                                cc(imageViews.get(index1));
                            }else {
                                changeColor(imageViews.get(index1), imageViews.get(index1-27));
                            }
                        }else if (j==2){
                            changeColor(imageViews.get(index2), imageViews.get(index2-27));
                        }else {
                            changeColor(imageViews.get(index3), imageViews.get(index3 - 27));
                        }
                    }
                }

                if (i==0){
                    index1 = index1 - 27;
                    index2 = index2 - 27;
                    index3 = index3 -27;
                }else if (i==1){
                    index3 = index3 - 27;
                    index2 = index2 - 27;
                }
                i++;
            }
        } else if (index1 >= 36 && index1 <= 44){

            int i=0;
            while (i<=2){

                if (i==2){

                    cc(imageViews.get(index3));
                }else {

                    for (int j=1; j<=3;j++){

                        if (j==1){
                            if (i==1){
                                cc(imageViews.get(index1));
                            }else {
                                changeColor(imageViews.get(index1), imageViews.get(index1-27));
                            }
                        }else if (j==2){
                            if (i==1){
                                cc(imageViews.get(index2));
                            }else {
                                changeColor(imageViews.get(index2), imageViews.get(index2-27));
                            }
                        }else {
                            changeColor(imageViews.get(index3), imageViews.get(index3-27));
                        }
                    }
                }

                if (i==0){
                    index1 = index1 - 27;
                    index2 = index2 - 27;
                    index3 = index3 -27;
                }else if (i==1){
                    index3 = index3 - 27;
                }
                i++;
            }
        } else if (index1 >= 27 && index1 <=35){
            int i = 0;
            while (i<=1){

                if (i==1){

                    for (int j=1;j<=3;j++){

                        if (j==1){
                            cc(imageViews.get(index3));
                        }else if (j==2){
                            cc(imageViews.get(index2));
                        }else {
                            cc(imageViews.get(index1));
                        }
                    }
                }else {

                    for (int j=1; j<=3; j++){

                        if (j==1){
                            changeColor(imageViews.get(index1), imageViews.get(index1-27));
                        }else if (j==2){
                            changeColor(imageViews.get(index2), imageViews.get(index2-27));
                        }else {
                            changeColor(imageViews.get(index3), imageViews.get(index3 - 27));
                        }
                    }
                }

                index1 = index1 - 27;
                index2 = index2 - 27;
                index3 = index3 - 27;
                i++;
            }
        }else {

            cc(imageViews.get(index1));
            cc(imageViews.get(index2));
            cc(imageViews.get(index3));
        }
    }

    public void changeColor(ImageView imageView, ImageView imageView1){

        Object tag = imageView1.getTag();

        if (tag.equals(1)){
            imageView.setImageResource(R.drawable.blue);
            imageView.setTag(1);
        }else if (tag.equals(2)){
            imageView.setImageResource(R.drawable.green);
            imageView.setTag(2);
        }else if (tag.equals(3)){
            imageView.setImageResource(R.drawable.orange);
            imageView.setTag(3);
        }else if (tag.equals(4)){
            imageView.setImageResource(R.drawable.purple);
            imageView.setTag(4);
        }else if (tag.equals(5)){
            imageView.setImageResource(R.drawable.red);
            imageView.setTag(5);
        }else if (tag.equals(6)){
            imageView.setImageResource(R.drawable.yellow);
            imageView.setTag(6);
        }
    }

    public void cc(ImageView imageView){

        Collections.shuffle(number);
        if (number.get(0) == 1){
            imageView.setImageResource(R.drawable.blue);
            imageView.setTag(1);
        }else if(number.get(0) == 2){
            imageView.setImageResource(R.drawable.green);
            imageView.setTag(2);
        }else if(number.get(0) == 3){
            imageView.setImageResource(R.drawable.orange);
            imageView.setTag(3);
        }else if(number.get(0) == 4){
            imageView.setImageResource(R.drawable.purple);
            imageView.setTag(4);
        }else if(number.get(0) == 5){
            imageView.setImageResource(R.drawable.red);
            imageView.setTag(5);
        }else if(number.get(0) == 6){
            imageView.setImageResource(R.drawable.yellow);
            imageView.setTag(6);
        }
    }

    public void onRfresh(View view){
        refresh();
    }

    public void refresh(){

        imageClick = 0;
        for (int i=0;i<81;i++){

            Collections.shuffle(number);
            ImageView imageView = imageViews.get(i);
            if (number.get(0) == 1){
                imageView.setImageResource(R.drawable.blue);
                imageView.setTag(1);
            }else if(number.get(0) == 2){
                imageView.setImageResource(R.drawable.green);
                imageView.setTag(2);
            }else if(number.get(0) == 3){
                imageView.setImageResource(R.drawable.orange);
                imageView.setTag(3);
            }else if(number.get(0) == 4){
                imageView.setImageResource(R.drawable.purple);
                imageView.setTag(4);
            }else if(number.get(0) == 5){
                imageView.setImageResource(R.drawable.red);
                imageView.setTag(5);
            }else if(number.get(0) == 6){
                imageView.setImageResource(R.drawable.yellow);
                imageView.setTag(6);
            }
        }

        checkIt();
    }

    public void checkIt(){

        for (int i=0; i<imageViews.size(); i++){

            changeAutomatically(imageViews.get(i));
        }
    }

    public void changeAutomatically(ImageView imageView){

        globalNum = 0;
        //taking index
        int index1 = imageViews.indexOf(imageView);

        try{

            ImageView oneImage = null;
            ImageView twoImage = null;
            ImageView threeImage = null;
            ImageView fourImage = null;

            if (index1 == 80){
                threeImage = imageViews.get(index1-1);
                fourImage = imageViews.get(index1-2);
            }else if (index1 == 79){
                oneImage = imageViews.get(index1+1);
                threeImage = imageViews.get(index1-1);
                fourImage = imageViews.get(index1-2);
            }else if (index1 == 0){
                oneImage = imageViews.get(index1+1);
                twoImage = imageViews.get(index1+2);
            }else if (index1 == 1){
                oneImage = imageViews.get(index1+1);
                twoImage = imageViews.get(index1+2);
                threeImage = imageViews.get(index1-1);
            }else {
                oneImage = imageViews.get(index1+1);
                twoImage = imageViews.get(index1+2);
                threeImage = imageViews.get(index1-1);
                fourImage = imageViews.get(index1-2);
            }

            if ((index1 >= 0 && index1 < 7) || (index1 >= 9 && index1 <16) || (index1 >=18 && index1 <25) || (index1 >= 27 && index1 <34)
                    || (index1 >= 36 && index1 <43) || (index1 >= 45 && index1 <52) || (index1 >= 54 && index1 < 61) ||
                    (index1 >= 63 && index1 < 70) || (index1 >= 72 && index1 < 79)){
                //TODO: to check only forward 2 numbers
                if (imageView.getTag().equals(oneImage.getTag()) && imageView.getTag().equals(twoImage.getTag())){
                    //changeImage(imageView, oneImage, twoImage, imageView.getTag());
                    exchangeImageOfHorizontal(imageView, oneImage, twoImage);
                    globalNum++;
                }

            }
            if ((index1 > 0 && index1 <= 7) || (index1 > 9 && index1 <=16) || (index1 >18 && index1 <=25) || (index1 > 27 && index1 <=34)
                    || (index1 > 36 && index1 <=43) || (index1 > 45 && index1 <=52) || (index1 > 54 && index1 <=61) ||
                    (index1 > 63 && index1 <= 70) || (index1 > 72 && index1 <= 79)){
                if (imageView.getTag().equals(oneImage.getTag()) && imageView.getTag().equals(threeImage.getTag())){

                    //changeImage(oneImage, imageView,threeImage, imageView.getTag());
                    exchangeImageOfHorizontal(oneImage, imageView, threeImage);
                    globalNum++;
                }
                //TODO: to check with middle index
            }
            if ((index1 > 1 && index1 <= 8) || (index1 > 10 && index1 <=17) || (index1 >19 && index1 <=26) || (index1 > 28 && index1 <=35)
                    || (index1 > 37 && index1 <=44) || (index1 > 46 && index1 <=53) || (index1 > 55 && index1 <= 62) ||
                    (index1 > 64 && index1 <= 71) || (index1 > 73 && index1 <=80)){

                //TODO: to check only backward
                if (imageView.getTag().equals(threeImage.getTag()) && imageView.getTag().equals(fourImage.getTag())){

                    //changeImage(fourImage, threeImage, imageView, imageView.getTag());
                    exchangeImageOfHorizontal(fourImage, threeImage, imageView);
                    globalNum++;
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "Hmmm that's not fair", Toast.LENGTH_SHORT).show();
        }
        globalNum = 0;

        //=============================checking vertical======================================//

        try{

            ImageView oneImage = null;
            ImageView twoImage = null;
            ImageView threeImage = null;
            ImageView fourImage = null;

            //TODO Vertical checking
            if(index1 >= 0 && index1 <=62){
                oneImage = imageViews.get(index1+9);
                twoImage = imageViews.get(index1+18);
                if (imageView.getTag().equals(oneImage.getTag()) && imageView.getTag().equals(twoImage.getTag())){
                    //changeImage(imageView, oneImage, twoImage, imageView.getTag());
                    exchangeImageOfVertical(imageView, oneImage, twoImage);
                }
            }
            if (index1 >=9 && index1 <=71){
                oneImage = imageViews.get(index1-9);
                twoImage = imageViews.get(index1+9);
                if (imageView.getTag().equals(oneImage.getTag()) && imageView.getTag().equals(twoImage.getTag())){
                    //changeImage(oneImage, imageView, twoImage, imageView.getTag());
                    exchangeImageOfVertical(oneImage, imageView, twoImage);
                }
            }
            if (index1 >=18 && index1 <= 80){

                oneImage = imageViews.get(index1-18);
                twoImage = imageViews.get(index1-9);
                if (imageView.getTag().equals(oneImage.getTag()) && imageView.getTag().equals(twoImage.getTag())){
                    //changeImage(oneImage, twoImage, imageView, imageView.getTag());
                    exchangeImageOfVertical(oneImage, twoImage, imageView);
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "Hmmm that's not fair", Toast.LENGTH_SHORT).show();
        }
    }
}
