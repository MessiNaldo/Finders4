package com.jmy.finders4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.google.android.gms.maps.model.LatLng
import com.jmy.finders4.workers.SendLatLng
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doWorkPeriodic()
        setFragment(1)

    }

    fun setFragment(int: Int){
        val listFragment: ListFragment = ListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.addToBackStack("polelist")
        when(int){
            1 -> transaction.add(R.id.mainFrameLayout, listFragment).commit()
        }
    }

    private fun doWorkPeriodic(){
        val workRequest = PeriodicWorkRequestBuilder<SendLatLng>(5, TimeUnit.SECONDS).build()
        val workManager = WorkManager.getInstance()
        workManager?.enqueue(workRequest)
    }

    fun goBack(){
        onBackPressed()
    }

    fun loadData(): MutableList<Pole>{
        val data: MutableList<Pole> = mutableListOf()

        var pole= Pole(
            R.drawable.animal1, "농협은행 간석지점", "인천광역시 간석2동 207-2",
            "농협은행 간석지점입니다. 저희 지점을 찾아주셔서 감사합니다. 예금창구는 1층 대출창구는 2층입니다.", "1km",
            LatLng(37.46254127833991, 126.70857244732896 )
        )
        data.add(pole)
        pole = Pole(
            R.drawable.animal2, "농협은행 여수시지부", "전라남도 여수시 교동 411",
            "교동과 이순신광장이용시 거리 & 가격 & 여유공간등 가장 합리적인 선택을 할 수 있는 주차장으로 이용가능. 검색해도 잘 안나오는 숨은주차장맛집(여행객기준)",
            "353km", LatLng(34.742763649920484, 127.73253761367098)
        )
        data.add(pole)
        pole = Pole(
            R.drawable.animal3, "농협은행 제주수련원", "제주특별자치도 서귀포시 표선면 세화리",
            "이렇게 고급스럽고 넓은 현관문 이라니...\n" +
                    "모든 방과 거실에  LG시스템에어컨 설치되어 있고 한샘 주방가구, 인덕션..\n" +
                    "냉장고 이렇게 큰거 처음 봄.…", "420km", LatLng(33.318745179811195, 126.81037955736313)
        )
        data.add(pole)
        pole = Pole(
            R.drawable.animal4, "대전광역시청", "대전광역시 서구 둔산동 둔산로 100",
            "잘 꾸며지고 가꿔진 시설물들. 그리고 주변의 편의시설이 도심내 공원을 연상시킵니다.", "4km", LatLng(36.35061221914832, 127.38485088485345)
        )
        data.add(pole)
        pole = Pole(
            R.drawable.animal5, "서울특별시청", "서울특별시 중구 명동 세종대로 110",
            "2012년에 세운 정부의 현대적인 명소로, 1925년에 지었으며 현재는 도서관이 된 옛 시청 건물 옆에 있습니다.", "21km", LatLng(37.56894756265856, 126.97799770047119)
        )
        data.add(pole)
        pole = Pole(
            R.drawable.animal6, "The Westin Josun Busan", "부산광역시 해운대구 동백로 67", "해운대 해수욕장이 내려다보이는 이 현대적인 호텔은 버스 정류장에서 도보로 4분, 벡스코에서 버스로 20분 거리에 있습니다.\n" +
                "세련된 객실에 평면 TV, 미니바, 무료 Wi-Fi가 구비되어 있으며 대부분의 객실에서 바다 전망을 감상할 수 있습니다. 클럽 레벨 객실 투숙객은 전용 라운지를 이용할 수 있습니다. 스위트룸에는 거실이 추가되고, 일부 스위트룸에는 주방과 월풀 욕조가 마련되어 있습니다. 룸서비스도 이용 가능합니다.\n" +
                "조식과 주차는 무료입니다. 식사 옵션으로는 우아한 아시아 레스토랑, 이탈리안 카페, 아이리시 펍, 최상층의 화려한 칵테일 라운지가 있습니다. 비즈니스 센터와 실내 수영장, 온수 욕조, 사우나가 있는 헬스장도 이용할 수 있습니다.",
            "360km", LatLng(35.156068583864375, 129.1541115593964)
        )
        data.add(pole)
        pole = Pole(
            R.drawable.animal7, "서울대학교", "서울특별시 관악구 관악로 1 서울대학교 생명과학부 504동",
            "1946년에 설립된 명문 국립대로 연구 중심의 글로벌 대학입니다.", "19km",
            LatLng(37.45671388055001, 126.95008141371318)
        )
        data.add(pole)
        pole = Pole(
            R.drawable.animal8, "경도cc", "전라남도 여수시 경호동 306-3", "멋진 풍경, 좋은 그린상태입니다.\n" +
                "숙소는 좀  오래되었지만 깨끗한 편입니다.", "358km", LatLng(34.71350744546328, 127.72511988481975)
        )
        data.add(pole)
        pole = Pole(
            R.drawable.animal9, "강릉원주대학교", "강원도 강릉시 경포동 죽헌길 7", "주말에 나들이하기 좋습니다.\n" +
                "운동장은 현재 잔디가 깔려있고 400미터 우레탄트랙이 깔려 있어 운동하는 사람이 제법 많이 방문하는 편입니다.\n" +
                "도서관은 QR코드 인식방식으로 출입해야 하며 구성원이 아니면 출입할 수 없습니다.", "105km", LatLng(37.77046729071558, 128.8690240051063)
        )
        data.add(pole)
        pole = Pole(
            R.drawable.animal10, "대천서중학교", "충청남도 보령시 신흑동 824",
            "대천서중학교(大川西中學校)는 충청남도 보령시 신흑동에 있는 공립 중학교입니다.", "88km", LatLng(36.317964339657564, 126.51393915416485)
        )
        data.add(pole)

        return data
    }
}