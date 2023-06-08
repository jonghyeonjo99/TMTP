# TMTP_backend

* 의약품 정보 API 관련

- 공공데이터포털에서 의약품에 대한 openAPI 활용신청(식별정보, 개요정보)

- openAPI사용을 승인받고 API 내용 중, 내가 원하는 정보만 따로 파싱하여 DATABASE에 저장(AWS RDS)

- 의약품의 식별정보 openAPI와 의약품 개요정보 openAPI를 받아와 공통되는 제품코드를 갖고있는
  의약품들을 SQL문 JOIN TABLE을 이용하여 하나의 Table에 저장하였다.

- AWS RDS를 AWS EC2서버에 연결하여 RDS의 데이터베이스에 담긴 정보를 RESTAPI형태로 배포


* SERVER 구축

- AWS RDS서버에 데이터베이스(MariaDB)를 만들어 openAPI에서 필요한 정보를 가져와 저장하였다.
  -> 항상 openAPI를 조회하게 되면 웹페이지의 로딩시간이 굉장히 오래걸렸기 때문.

- AWS EC2서버를 생성하여 RDS서버를 연동시켜 외부 환경에서 RDS의 데이터베이스 정보에 접근이 가능하도록 하였다.
