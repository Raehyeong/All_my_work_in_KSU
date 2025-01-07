/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab #: Assignment12
*/

import java.lang.String;
import java.util.Scanner;

class JobLead {

    private String companyName;
    private String contactName;
    private String contactPhone;
    private String jobTitle;
    private String jobDescription;

    public JobLead() {
        this.companyName = null;
        this.contactName = null;
        this.contactPhone = null;
        this.jobTitle = null;
        this.jobDescription = null;
    }

    public JobLead(String companyName, String contactName, String contactPhone, String jobTitle, String jobDescription) {
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getContactPhone() {
        return contactPhone;
    }
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getJobDescription() {
        return jobDescription;
    }
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        String str = "";
        str = str + "Company: " + companyName + ", " + "Contact Name: " + contactName + ", " + "Contact Phone: " + contactPhone + ", " + "Job Title: " + jobTitle + ", " + "Job Description: " + jobDescription + "\n";
        return str;
    }
}


class JobLeadsNode {

    public JobLead jobLead;
    public JobLeadsNode prevJobLead;
    public JobLeadsNode nextJobLead;
    public JobLeadsNode(JobLead jobLead) {
        this.jobLead = jobLead;
        this.prevJobLead = null;
        this.nextJobLead = null;
    }
}

class JobLeadsList {
    private JobLeadsNode head;
    private JobLeadsNode tail;


    public JobLeadsList() {
        this.head = null;
        this.tail = null;
    }

    public void addtoFront(String companyName, String contactName, String contactPhone, String jobTitle, String jobDescription) {
        JobLead newJobLead = new JobLead(companyName, contactName, contactPhone, jobTitle, jobDescription);
        JobLeadsNode newJobLeadNode = new JobLeadsNode(newJobLead);
        if (this.head == null && this.tail == null) {
            this.head = this.tail = newJobLeadNode;
        } else {
            JobLeadsNode temp = this.head;
            this.head = newJobLeadNode;
            this.head.nextJobLead = temp;
            temp.prevJobLead = this.head;
        }
        System.out.println("");
    }

    public void addtoTail(String companyName, String contactName, String contactPhone, String jobTitle, String jobDescription) {
        JobLead newJobLead = new JobLead(companyName, contactName, contactPhone, jobTitle, jobDescription);
        JobLeadsNode newJobLeadNode = new JobLeadsNode(newJobLead);
        if (this.head == null && this.tail == null) {
            this.head = this.tail = newJobLeadNode;
        } else {
            JobLeadsNode temp = this.tail;
            this.tail = newJobLeadNode;
            this.tail.prevJobLead = temp;
            temp.nextJobLead = this.tail;
        }
        System.out.println("");
    }


    public void removeLead(String companyName, String jobTitle) {
        JobLeadsNode temp;

        if (this.head == null) {
            System.out.println("List is empty.");
            return;
        }

        for (temp = this.head; temp != null; temp = temp.nextJobLead) {
            if (temp.jobLead.getCompanyName().equals(companyName) && temp.jobLead.getJobTitle().equals(jobTitle)) {
                if (temp.prevJobLead != null)
                    temp.prevJobLead.nextJobLead = temp.nextJobLead;
                if (temp.nextJobLead != null)
                    temp.nextJobLead.prevJobLead = temp.prevJobLead;
                temp = null;
                System.out.println("Job Lead Deleted.");
                return;
            }
        }
        if (temp == null) {
            System.out.println("Error: Job Lead Not Found.\n");
            return;
        }
    }

    public void printHeadtoTail() {
        JobLeadsNode temp = this.head;
        if (temp == null) {
            System.out.println("List is empty.");
            return;
        } else {

            while (temp != null) {
                System.out.println(temp.jobLead.toString());
                temp = temp.nextJobLead;
            }
        }
    }

    public void printTailtoHead() {
        JobLeadsNode temp = this.tail;
        if (temp == null) {
            System.out.println("List is empty.");
            return;
        } else {
            while (temp != null) {
                System.out.println(temp.jobLead.toString());
                temp = temp.prevJobLead;
            }
        }
    }
}


class Assignment12 {
    public static void main(String[] args) {

        JobLeadsList jobList = new JobLeadsList();

        Scanner scan = new Scanner(System.in);

        String companyName;
        String contactName;
        String contactPhone;
        String jobTitle;
        String jobDescription;

        int choice = 0;
        while (true) {
            System.out.println("1 – Add lead to head of list");
            System.out.println("2 – Add lead to tail of list");
            System.out.println("3 – Delete a lead");
            System.out.println("4 - Print list head to tail");
            System.out.println("5 - Print list tail to head");
            System.out.println("6 - Exit\n");
            System.out.print("Enter Choice: ");
            choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Company Name: ");
                    companyName = scan.nextLine();
                    System.out.print("Enter Contact Person Name: ");
                    contactName = scan.nextLine();
                    System.out.print("Enter Contact Person Phone: ");
                    contactPhone = scan.nextLine();
                    System.out.print("Enter Job Title: ");
                    jobTitle = scan.nextLine();
                    System.out.print("Enter Job Description: ");
                    jobDescription = scan.nextLine();
                    jobList.addtoFront(companyName, contactName, contactPhone, jobTitle, jobDescription);
                    break;
                case 2:
                    System.out.print("Enter Company Name: ");
                    companyName = scan.nextLine();
                    System.out.print("Enter Contact Name: ");
                    contactName = scan.nextLine();
                    System.out.print("Enter Contact Phone: ");
                    contactPhone = scan.nextLine();
                    System.out.print("Enter Job Title: ");
                    jobTitle = scan.nextLine();
                    System.out.print("Enter Job Description: ");
                    jobDescription = scan.nextLine();
                    jobList.addtoTail(companyName, contactName, contactPhone, jobTitle, jobDescription);
                    break;
                case 3:
                    System.out.print("Enter Company Name: ");
                    companyName = scan.nextLine();
                    System.out.print("Enter Job Title: ");
                    jobTitle = scan.nextLine();
                    jobList.removeLead(companyName, jobTitle);
                    break;
                case 4:
                    jobList.printHeadtoTail();
                    break;
                case 5:
                    jobList.printTailtoHead();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Error: Please enter a valid choice (1 thru 6)\n");
            }
        }
    }
}