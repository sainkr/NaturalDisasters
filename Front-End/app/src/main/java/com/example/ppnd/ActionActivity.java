package com.example.ppnd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActionActivity extends AppCompatActivity {
    TextView text_title, text_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        text_title = (TextView) findViewById(R.id.text_title);
        text_content = (TextView) findViewById(R.id.text_content);

        Intent intent = getIntent();
        String type = intent.getExtras().getString("type");

        if(type.equals("earthquake")){
            text_title.setText("지진 행동요령");
            text_content.setText("\uF09F 지진 발생 시\n" +
                    "1. 튼튼한 탁자 아래에 들어가 몸을 보호합니다.\n" +
                    "∙ 지진으로 크게 흔들리는 시간은 길어야 1~2분 정도입니다.\n" +
                    "∙ 튼튼한 탁자의 아래로 들어가 탁자 다리를 꼭 잡고 몸을 보호합니다.\n" +
                    "∙ 탁자 아래와 같이 피할 곳이 없을 때에는 방석 등으로 머리를 보호합니다.\n" +
                    "2. 가스와 전깃불을 차단하고 문을 열어 출구를 확보합니다.\n" +
                    "∙ 흔들림이 멈춘 후 당황하지 말고 화재에 대비하여 가스와 전깃불을 끕니다.\n" +
                    "∙ 문이나 창문을 열어 언제든 대피할 수 있도록 출구를 확보합니다.\n" +
                    "∙ 흔들림이 멈추면, 출구를 통해 밖으로 나갑니다.\n" +
                    "3. 집에서 나갈 때는 신발은 꼭 신고 이동합니다.\n" +
                    "∙ 지진이 발생하면 유리 조각이나 떨어져 있는 물체 때문에 발을 다칠 수 있으니, 발을 보호할 수 있는 신발을 신고 이동합니다.\n" +
                    "4. 계단을 이용하여 밖으로 대피합니다.\n" +
                    "∙ 지진이 나면 엘리베이터가 멈출 수 있으므로 타지 말고, 계단을 이용하여 건물 밖으로 대피합니다.\n" +
                    "∙ 밖으로 나갈 때에는 떨어지는 유리, 간판, 기와 등에 주의하며, 소지품으로 몸을 보호하면서 침착하게 대피합니다.\n" +
                    "5. 건물이나 담장으로부터 떨어져 이동합니다.\n" +
                    "∙ 건물 밖으로 나오면 담장, 유리창 등이 파손되어 다칠 수 있으니, 건물과 담장에서 최대한 멀리 떨어져 가방이나 손으로 머리를 보호하면서 대피합니다.\n" +
                    "6. 낙하물이 없는 넓은 공간으로 대피합니다.\n" +
                    "∙ 떨어지는 물건에 주의하며 신속하게 운동장이나 공원 등 넓은 공간으로 대피합니다.\n" +
                    "∙ 이동할 때에는 차량을 이용하지 않고 걸어서 대피합니다.\n" +
                    "7. 올바른 정보에 따라 행동합니다.\n" +
                    "∙ 대피 장소에서는 안내에 따라 질서를 지킵니다.\n" +
                    "∙ 지진 발생 직후에는 근거 없는 소문이나 유언비어가 유포될 수 있으니, 라디오나 공공기관의 안내 방송 등이 제공하는 정보에 따라 행동합니다.");

        }
        else if(type.equals("typoon")){
            text_title.setText("태풍 행동요령");
            text_content.setText("\uF09F 국민행동요령\n" +
                    "- 자주 물에 잠기는 지역, 산사태 위험지역 등의 위험한 곳은 피하고 안전한 곳으로 대피합니다.\n" +
                    "- 실내에서는 문과 창문을 닫고, 외출을 하지 않고 TV, 라디오, 인터넷 등을 통해 기상상황을 확인합니다.\n" +
                    "- 개울가, 하천변, 해안가 등 침수 위험지역은 급류에 휩쓸릴 수 있으니 가까이 가지 않습니다.\n" +
                    "- 산과 계곡의 등산객은 계곡이나 비탈면 가까이 가지 않고 안전한 곳으로 대피합니다.\n" +
                    "- 공사자재가 넘어질 수 있으니 공사장 근처에 가까이 가지 않습니다.\n" +
                    "- 농촌에서는 논둑이나 물꼬의 점검을 위해 나가지 않습니다.");
        }
        else if(type.equals("thunder")){
            text_title.setText("낙뢰 행동요령");
            text_content.setText("\uF09F 국민행동요령\n" +
                    "- 낙뢰 예보시 외출을 삼가고 외부에 있을 땐 자동차 안, 건물 안, 지하 등 안전한 곳으로 대피합니다.\n" +
                    "- 전기제품의 플러그를 빼고, 1m이상 거리를 유지합니다.\n" +
                    "- 산 위 암벽이나 키 큰 나무 밑은 위험하므로 낮은 자세로 안전한 곳으로 빨리 대피합니다.\n" +
                    "- 등산용 스틱이나 우산 같이 긴 물건은 몸에서 멀리합니다.\n" +
                    "- 평지에서는 몸을 낮게하고 물기가 없는 움푹 파인 곳으로 대피합니다.\n" +
                    "- 골프, 낚시 등 야외활동 중일 때 장비를 몸에서 떨어뜨리고, 안전한 곳으로 대피합니다.\n" +
                    "\n" +
                    "∙30-30 안전규칙을 지킵니다.\n" +
                    "번개가 친 이후 30초 이내에 천둥이 울리면, 즉시 안전한 장소로 대피합니다.\n" +
                    "마지막 천둥소리가 난 후 30분 정도 더 기다린 후에 움직입니다.");

        }
        else if(type.equals("heatwave")){
            text_title.setText("폭염 행동요령");
            text_content.setText("- 핵심 행동요령\n" +
                    " TV, 라디오, 인터넷 등에서 폭염이 예보된 때에는 최대한 야외활동을 자제하고 주변의 독거노인 등 건강이 염려되는 분들의 안부를 살펴봅니다.\n" +
                    "\n" +
                    "- 상세 행동요령\n" +
                    "\n" +
                    "1. 일반 가정에서는 가족들과 함께\n" +
                    "∙ 야외활동을 최대한 자제하고, 외출이 꼭 필요한 경우에는 창이 넓은 모자와 가벼운 옷차림을 하고 물병을 반드시 휴대합니다.\n" +
                    "∙ 물을 많이 마시고, 카페인이 들어간 음료나 주류는 마시지 않습니다.\n" +
                    "∙ 냉방이 되지 않는 실내에서는 햇볕을 가리고 맞바람이 불도록 환기를 합니다.\n" +
                    "∙ 창문이 닫힌 자동차 안에는 노약자나 어린이를 홀로 남겨두지 않습니다.\n" +
                    "∙ 거동이 불편한 노인, 신체허약자, 환자 등을 남겨두고 장시간 외출할 경우에는 친인척, 이웃 등에 부탁하고 전화 등으로 수시로 안부를 확인합니다.\n" +
                    "∙ 현기증, 메스꺼움, 두통, 근육경련 등의 증세가 보이는 경우에는 시원한 곳으로 이동하여 휴식을 취하고 시원한 음료를 천천히 마십니다.\n" +
                    "\n" +
                    "2. 직장에서는 직원들과 함께\n" +
                    "∙ 휴식시간은 장시간 한 번에 쉬기보다는 짧게 자주 갖는 것이 좋습니다.\n" +
                    "∙ 야외 행사, 스포츠경기 등 각종 외부 행사를 자제합니다.\n" +
                    "∙ 점심시간 등을 이용하여 10~15분 정도의 낮잠으로 개인 건강을 유지합니다.\n" +
                    "∙ 직장인들은 편한 복장으로 출근하여 체온을 낮추도록 노력합니다.\n" +
                    "∙ 냉방이 되지 않는 실내에서는 햇볕이 실내에 들어오지 않도록 하고, 환기가 잘 되도록 선풍기를 켜고 창문이나 출입문을 열어둡니다.\n" +
                    "∙ 건설 현장 등 실외 작업장에서는 폭염안전수칙(물, 그늘, 휴식)을 항상 준수하고, 특히, 취약시간(오후 2~5시)에는 ‘무더위 휴식시간제’를 적극 시행합니다.\n" +
                    "\n" +
                    "3. 학교에서는 학생들과 함께\n" +
                    "∙ 초·중·고등학교에서 에어컨 등 냉방장치 운영이 곤란한 경우에는 단축수업, 휴교 등 학사일정 조정을 검토하고, 식중독 사고가 발생하지 않도록 주의합니다.\n" +
                    "∙ 냉방이 되지 않는 실내에서는 햇볕이 실내에 들어오지 않도록 하고, 환기가 잘 되도록 선풍기를 켜고 창문이나 출입문을 열어둡니다.\n" +
                    "∙ 운동장에서의 체육활동 및 소풍 등 각종 야외활동을 자제합니다.\n" +
                    "\n" +
                    "4. 축사ㆍ양식장에서는 지역 주민들과 함께\n" +
                    "∙ 축사 창문을 개방하고 지속적인 환기를 실시하며, 적정 사육 밀도를 유지합니다.\n" +
                    "∙ 비닐하우스, 축사 천장 등에 물 분무 장치를 설치하여 복사열을 낮춥니다.\n" +
                    "∙ 양식 어류는 꾸준히 관찰하고, 얼음을 넣는 등 수온 상승을 억제합니다.\n" +
                    "∙ 가축·어류 폐사 시 신속하게 방역기관에 신고하고 조치에 따릅니다.\n" +
                    "\n" +
                    "5. 무더위쉼터 이용\n" +
                    "∙ 외부에 외출 중인 경우나 자택에 냉방기가 설치되어 있지 않은 경우 가장 더운 시간에는 인근 무더위쉼터로 이동하여 더위를 피합니다.\n" +
                    "무더위쉼터는 안전디딤돌 앱, 시군구 홈페이지 등에서 확인할 수 있으며 평소에 위치를 확인해 둡니다.");

        }
        else if(type.equals("rain")){

            text_title.setText("호우 행동요령");
            text_content.setText("\uF09F 국민행동요령\n" +
                    "\n" +
                    "- 자주 물에 잠기는 지역, 산사태 위험지역 등의 위험한 곳은 피하고 안전한 곳으로 대피합니다.\n" +
                    "- 실내에서는 문과 창문을 닫고, 외출을 하지 않고 TV, 라디오, 인터넷 등을 통해 기상상황을 확인합니다.\n" +
                    "- 개울가, 하천변, 해안가 등 침수 위험지역은 급류에 휩쓸릴 수 있으니 가까이 가지 않습니다.\n" +
                    "- 산과 계곡의 등산객은 계곡이나 비탈면 가까이 가지 않고 안전한 곳으로 대피합니다.\n" +
                    "- 공사자재가 넘어질 수 있으니 공사장 근처에 가까이 가지 않습니다.\n" +
                    "- 농촌에서는 논둑이나 물꼬의 점검을 위해 나가지 않습니다.");
        }
        else if(type.equals("snow")){
            text_title.setText("대설 행동요령");
            text_content.setText("\uF09F 국민 행동요령\n" +
                    "\n" +
                    "- 산간 고립 우려 지역에서는 식량, 연료 등 비상용품을 준비합니다.\n" +
                    "- 내 집 앞 눈을 수시로 치웁니다.\n" +
                    "- 스노체인, 염화칼슘, 삽 등 자동차 월동용품을 준비합니다.\n" +
                    "- 개인 차량 이용을 줄이고 대중교통을 이용합니다.\n" +
                    "- 차량 운행 시에는 저속 운행하고 안전거리를 확보합니다.\n" +
                    "- 차량이 고립될 때는 119에 신고하고 차 안에서 TV, 라디오, 인터넷 등을 통해 기상 상황을 확인하며 구조를 기다립니다.");

        }


    }
}
