package com.example.bribe;

    public class Member {
        private String Name;
        private String Complaint;
        private Long Aadhar;
        private float Mobile;

        public Member()
        {

        }
        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getComplaint() {
            return Complaint;
        }

        public void setComplaint(String complaint) { Complaint = complaint; }

        public Long getAadhar() { return Aadhar; }

        public void setAadhar(Long aadhar) {
            this.Aadhar = aadhar;
        }

        public float getMobile() {
            return Mobile;
        }

        public void setMobile(float mobile) {
            this.Mobile = mobile;
        }

    }

