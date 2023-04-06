# #ERD
<div align="center">
  <img src="https://user-images.githubusercontent.com/76987021/230394867-b0dce856-da02-4475-ac20-91cacf5bee0c.png">
</div>

# #데이터 모델링
<div>
  <h3>관계 설명</h3>
  
  <h4>SITE - MENU</h4>
  <p>
    각 사이트에 메뉴가 각각 다른 메뉴가 포함되어 메뉴는 사이트와 종속관계<br>
    사이트 하나당 여러개의 메뉴가 존재할 것이므로 사이트와 메뉴는 1:다 관계가 된다.
  </p>
  
  <h4>GROUP - USER</h4>
  <p>
    하나의 그룹은 여러 사용자를 가지므로 1:다 관계가 되고<br>
    그룹은 독립적으로 존재할 수 없지만 사용자는 독립적으로 존재할 수 있으므로 그룹은 사용자에 종속되는 관계이다.<br>
  </p>
  
  <h4>GROUP - MENU</h4>
  <p>
    하나의 그룹은 여러 메뉴에 접근할 수 있고, 하나의 메뉴는 여러 그룹에서 접근할 수 있으므로 다:다 관계가 되어<br>
    중간에 그룹과 메뉴를 매핑하는 테이블을 두어 1:다 다:1 관계가 된다.<br>
  </p>
  
  <h4>GROUP - SITE</h4>
  <p>
    하나의 그룹은 여러 사이트에 접근할 수 있고, 하나의 사이트는 여러 그룹에서 접근할 수 있으므로 다:다 관계가 되어<br>
    중간에 그룹과 사이트를 매핑하는 테이블을 두어 1:다 다:1 관계가 된다.<br>
  </p>

  <h3>테이블 정보</h3>
  
  - CTADM_USER 테이블
  <img src="https://user-images.githubusercontent.com/76987021/228565859-90c29f5c-d350-4794-9989-304fc005b2d8.png">

  - CTADM_GROUP 테이블
  <img src="https://user-images.githubusercontent.com/76987021/228564149-599e4ee0-7f98-4c38-96e6-69b1d17ccfd3.png">

  - CTADM_SITE 테이블
  <img src="https://user-images.githubusercontent.com/76987021/228564758-d3724c32-e458-4a7f-9913-fb35407d0f7e.png">

  - CTADM_ACCESS_SITE 테이블
  <img src="https://user-images.githubusercontent.com/76987021/228565008-259b057d-91db-4c8f-8b33-bdb50e9c7f0e.png">

  - CTADM_MENU 테이블
  <img src="https://user-images.githubusercontent.com/76987021/228565168-941a4269-1d36-4703-a2be-03e3a2b72b36.png">

  - CTADM_ACCESS_MENU 테이블
  <img src="https://user-images.githubusercontent.com/76987021/228565288-71ffa455-b6a4-462e-a8b6-e00a00a5342a.png">
  
</div>

  
