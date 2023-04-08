#ifndef ITEM_H
#define ITEM_H
#include <string>

// void Item(std::string name, int price);
// std::string to_string();

class Item{

    friend std::ostream& operator << (std::ostream& os, const Item& Item);

    private:
    std::string _name;
    int _price;

    public:
    Item();
    Item(std::string name, int price);
   

    // std::string to_string();
};

#endif